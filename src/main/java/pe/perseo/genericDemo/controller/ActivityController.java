package pe.perseo.genericDemo.controller;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.perseo.genericDemo.dto.ActivityDTO;
import pe.perseo.genericDemo.response.ActivityResponse;
import pe.perseo.genericDemo.service.ActivityService;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.ExecutionException;

@Log4j2
@Getter
@RestController
@RequestMapping("sc/v1.0/info-activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping(path = "/prueba")
    public ResponseEntity<?> getPrueba(@RequestHeader HttpHeaders httpHeaders)
    {
        log.info("######################   Prueba  ##################");
        log.debug("mensage debug");
        log.info("mensaje info");
        log.error("mensaje error");
        log.warn("mensaje warm");
        log.fatal("mensjae fatal");

        return new ResponseEntity<>(null,httpHeaders, HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/activities")
    @ResponseBody
    public ResponseEntity<Flux<ActivityResponse>> getActivities(@RequestHeader HttpHeaders httpHeaders) throws ExecutionException, InterruptedException
    {
        log.info("######################   consulta de activities  ##################");

        Flux<ActivityResponse> resultado = this.activityService.consultarTodos()
                .map(actDTO -> ActivityDTO.mapDTOtoResponse(actDTO));

        return resultado.hasElements()
                .map(noVacio->{
                    if(Boolean.TRUE.equals(noVacio))
                    {
                        log.info("con contenido");
                        return new ResponseEntity<>(resultado,httpHeaders, HttpStatus.OK);
                    } else{
                        log.info("sin contenido");
                        return new ResponseEntity<>(resultado, HttpStatus.NO_CONTENT);
                    }
                })
                .subscribeOn(Schedulers.boundedElastic()).toFuture().get();

    }




}
