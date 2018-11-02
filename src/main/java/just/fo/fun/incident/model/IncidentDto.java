package just.fo.fun.incident.model;

import just.fo.fun.entities.Incident;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IncidentDto {

    private Long id;
    private String name;
    private String description;
    private int dangerLevel;
    private String incidentType;
    private String vehicleType;
    private String atachment;

    public IncidentDto(Incident incident) {

        this.id = incident.getId();
        this.name = incident.getName();
        this.description = incident.getDescription();
        this.dangerLevel = incident.getDangerLevel();
        this.incidentType = incident.getIncidentType() == null ? null : incident.getIncidentType().getName();
        this.vehicleType = incident.getVehicleType() == null ? null : incident.getVehicleType().getName();
        this.atachment = incident.getAtachment();
    }
}
