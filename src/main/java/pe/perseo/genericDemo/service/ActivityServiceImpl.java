package pe.perseo.genericDemo.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pe.perseo.genericDemo.dao.ActivityRepository;
import pe.perseo.genericDemo.dto.ActivityDTO;
import reactor.core.publisher.Flux;

/**
 * Representa una clase de servicio para las actividades.
 * Permite realizar operaciones CRUD con las actividades.
 *
 * @author Wilber H.
 * @version 1.0
 */
@Log4j2
@Service
public class ActivityServiceImpl implements ActivityService{

    //? inyectando via constructor la interface ActivityRepository
    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository)
    {
        this.activityRepository = activityRepository;
    }

    /**
     * Lista todas las actividades.
     *
     * @param ND
     * @return Listado de actidades
     */
    @Override
    public Flux<ActivityDTO> consultarTodos()
    {
        return Flux.fromIterable(this.activityRepository.findAll())
                .map(activity -> {
                    log.info("ralizando procesamiendo :{}",activity.toString());
                    return ActivityDTO.mapEntityToActivityDTO(activity);
                })
                .onErrorMap(error->{
                    log.error("error al recuperar datos:{}",error.getStackTrace());
                    return new RuntimeException("#### Error generado ####");
                })
                .switchIfEmpty(Flux.empty())
                ;
    }
}
