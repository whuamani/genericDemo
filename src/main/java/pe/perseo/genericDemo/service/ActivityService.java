package pe.perseo.genericDemo.service;

import pe.perseo.genericDemo.dto.ActivityDTO;
import reactor.core.publisher.Flux;

public interface ActivityService {

    public Flux<ActivityDTO> consultarTodos();
}
