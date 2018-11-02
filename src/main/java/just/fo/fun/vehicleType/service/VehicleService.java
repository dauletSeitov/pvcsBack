package just.fo.fun.vehicleType.service;

import just.fo.fun.entities.VehicleType;
import just.fo.fun.vehicleType.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

//    public Category save(Category category){
//        return categoryRepository.save(category);
//    }
//
    public VehicleType findOne(Long id){
        return vehicleRepository.findOne(id);
    }
//
    public List<VehicleType> findAll(){
        return vehicleRepository.findAll();
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
