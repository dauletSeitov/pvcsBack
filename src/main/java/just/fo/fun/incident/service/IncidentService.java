package just.fo.fun.incident.service;

import just.fo.fun.entities.Incident;
import just.fo.fun.incident.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public Incident save(Incident incident){
        return incidentRepository.save(incident);
    }

    public Incident findOne(Long id){
        return incidentRepository.findOne(id);
    }

    public List<Incident> findAll(){
        return incidentRepository.findAll();
    }

    public void delete(Long id){
        incidentRepository.delete(id);
    }

    public List<Incident> getAll() {
         return incidentRepository.findAll();
    }
}
