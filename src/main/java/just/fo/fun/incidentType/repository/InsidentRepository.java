package just.fo.fun.incidentType.repository;

import just.fo.fun.entities.IncidentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsidentRepository extends JpaRepository<IncidentType, Long> {
}
