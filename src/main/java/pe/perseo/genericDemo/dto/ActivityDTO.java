package pe.perseo.genericDemo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import pe.perseo.genericDemo.dao.Activity;
import pe.perseo.genericDemo.response.ActivityResponse;

@Log4j2
@Builder
@Getter
@ToString
@Value
public class ActivityDTO {

    private final Integer activityId;
    private final String activityName;
    private final Integer activityCode;
    private final Integer stepId;
    private final String path;
    private final String method;

    //? mapper entity to DTO
    public static ActivityDTO mapEntityToActivityDTO(Activity activityEntity)
    {
        return ActivityDTO.builder()
                .activityId(activityEntity.getActivityId())
                .activityName(activityEntity.getActivityName())
                .activityCode(activityEntity.getActivityCode())
                .stepId(activityEntity.getStepId())
                .path(activityEntity.getPath())
                .method(activityEntity.getMethod())
                .build();
    }

    //? mapper DTO to response
    public static ActivityResponse mapDTOtoResponse(ActivityDTO activityDTO)
    {
        return ActivityResponse.builder()
                .activityId(activityDTO.getActivityId())
                .activityName(activityDTO.getActivityName())
                .activityCode(activityDTO.getActivityCode())
                .stepId(activityDTO.getStepId())
                .path(activityDTO.getPath())
                .method(activityDTO.getMethod())
                .build();
    }



}
