package just.fo.fun.entities;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Slf4j
@Entity
@ToString
@Data
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private int dangerLevel;

    @NotNull
    @ManyToOne
    //@JoinColumn(name = "user_id")
    private IncidentType incidentType;

    @NotNull
    @ManyToOne
    //@JoinColumn(name = "user_id")
    private VehicleType vehicleType;

    private String atachment;

}
