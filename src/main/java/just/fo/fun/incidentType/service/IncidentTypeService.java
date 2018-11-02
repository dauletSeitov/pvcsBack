package just.fo.fun.incidentType.service;

import just.fo.fun.entities.IncidentType;
import just.fo.fun.incidentType.repository.InsidentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentTypeService {

    @Autowired
    private InsidentTypeRepository incidentRepository;

//    public Category save(Category category){
//        return categoryRepository.save(category);
//    }
//
    public IncidentType findOne(Long id){
        return incidentRepository.findOne(id);
    }
//
    public List<IncidentType> findAll(){
        return incidentRepository.findAll();
    }
//
//    public void delete(Integer id){
//        categoryRepository.delete(id);
//    }
//

    public String getString( String str){
        return str.substring(0,2);
    }
}
