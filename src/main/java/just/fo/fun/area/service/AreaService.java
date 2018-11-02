package just.fo.fun.area.service;

import just.fo.fun.area.repository.AreaRepository;
import just.fo.fun.entities.Area;
import just.fo.fun.entities.IncidentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

//    public Category save(Category category){
//        return categoryRepository.save(category);
//    }
//
    public Area findOne(Long id){
        return areaRepository.findOne(id);
    }
//
    public List<Area> findAll(){
        return areaRepository.findAll();
    }
//
//    public void delete(Integer id){
//        categoryRepository.delete(id);
//    }
//

}
