package pe.perseo.genericDemo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;


@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityResponse {

    @JsonProperty("activity-id")
    private final Integer activityId;

    @JsonProperty("activity-name")
    private final String activityName;

    @JsonProperty("activity-code")
    private final Integer activityCode;

    @JsonProperty("step-id")
    private final Integer stepId;

    @JsonProperty("path")
    private final String path;

    @JsonProperty("method")
    private final String method;
}
