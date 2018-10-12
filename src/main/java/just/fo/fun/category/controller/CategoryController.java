package just.fo.fun.category.controller;

import just.fo.fun.category.service.CategoryService;
import just.fo.fun.entities.Category;
import just.fo.fun.entities.User;
import just.fo.fun.exception.MessageException;
import just.fo.fun.user.models.dtos.UserDto;
import just.fo.fun.user.service.UserService;
import just.fo.fun.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity insertUser(@Valid @RequestBody final Category category) {

        if (category.getId() != null)
            throw new MessageException("id must be empty !");

        Category result;
        try {
            result = categoryService.save(category);
        }catch (Exception e){
            throw new MessageException("can not save category" + e.getMessage());
        }
        return result == null
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity updateUser(@Valid @RequestBody final Category category) {

        if (category.getId() == null)
            throw new MessageException("id must not be empty !");
        Category result = categoryService.save(category);
        return result == null
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(result, HttpStatus.OK);

    }
/*
    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable final Long id) {

        UserDto userDto = new UserDto();
        User user = userService.findOne(id);

        BeanUtils.copyProperties(user, userDto);
        return userDto == null
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(userDto, HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity getUsers() {

        List<User> users = userService.findAll();

        List<UserDto> resultUserDto = users.stream().map(itm -> {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(itm, userDto);
            return userDto;
        }).collect(Collectors.toList());

        return resultUserDto == null
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(resultUserDto, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable final Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
*/

}
