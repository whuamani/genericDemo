package pe.perseo.genericDemo.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Activity",schema = "dbo")
public class Activity implements Serializable {

    @Serial
    private static final long serialVersionUID=44527L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ActivityId",updatable = false)
    private Integer activityId;

    @Column(name = "ActivityName")
    private String activityName;

    @Column(name = "ActivityCode")
    private Integer activityCode;

    @Column(name = "StepId")
    private Integer stepId;

    @Column(name = "path")
    private String path;

    @Column(name = "method")
    private String method;

}
