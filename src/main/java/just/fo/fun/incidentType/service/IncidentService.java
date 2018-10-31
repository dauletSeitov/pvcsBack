package just.fo.fun.incidentType.service;

import just.fo.fun.entities.IncidentType;
import just.fo.fun.incidentType.repository.InsidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    @Autowired
    private InsidentRepository insidentRepository;

//    public Category save(Category category){
//        return categoryRepository.save(category);
//    }
//
//    public Category findOne(Integer id){
//        return categoryRepository.findOne(id);
//    }
//
    public List<IncidentType> findAll(){
        return insidentRepository.findAll();
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
