package just.fo.fun.incident.service;

import just.fo.fun.entities.Incident;
import just.fo.fun.entities.Post;
import just.fo.fun.incident.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository postRepository;

    public Incident save(Incident incident){
        return postRepository.save(incident);
    }

    public Incident findOne(Long id){
        return postRepository.findOne(id);
    }

    public List<Incident> findAll(){
        return postRepository.findAll();
    }

    public void delete(Long id){
        postRepository.delete(id);
    }


    public List<Incident> getAll() {
         return postRepository.findAll();
    }
}
