package just.fo.fun.user.service;

import just.fo.fun.entities.User;
import just.fo.fun.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public User save(User user){
        return UserRepository.save(user);
    }

    public User findOne(Long id){
        return UserRepository.findOne(id);
    }

    public List<User> findAll(){
        return UserRepository.findAll();
    }

    public void delete(Long id){
        UserRepository.delete(id);
    }


}
