package just.fo.fun.auth.service;

import just.fo.fun.auth.model.AuthDto;
import just.fo.fun.entities.User;
import just.fo.fun.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

//    public Category save(Category vehicleType){
//        return categoryRepository.save(vehicleType);
//    }
//
//    public Category findOne(Integer id){
//        return categoryRepository.findOne(id);
//    }
//
//    public List<Category> findAll(){
//        return categoryRepository.findAll();
//    }
//
//    public void delete(Integer id){
//        categoryRepository.delete(id);
//    }


//    public String getString( String str){
//        return str.substring(0,2);
//    }


    public boolean login(AuthDto authDto){
        User user = userRepository.login(authDto.login, authDto.pwd);
        return user != null;
    }
}
