package just.fo.fun.incident.repository;

import just.fo.fun.entities.Incident;
import just.fo.fun.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

    @Query("select p from Incident p")
    Page<Incident> getAll(Pageable pageable);
}
