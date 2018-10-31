package just.fo.fun.auth.controller;

import just.fo.fun.auth.model.AuthDto;
import just.fo.fun.auth.service.AuthService;
import just.fo.fun.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity login(@Valid @RequestBody final AuthDto loginDto) {
            boolean result = authService.login(loginDto);

        return result
                ? new ResponseEntity<>(Collections.singletonMap(Constants.JSON_ONE_FIELD_VALUE, "success"), HttpStatus.OK)
                : new ResponseEntity<>(Collections.singletonMap(Constants.JSON_ONE_FIELD_VALUE, "no user found"), HttpStatus.CONFLICT);

    }
    @GetMapping
    public ResponseEntity login() {

        return  new ResponseEntity<>(Collections.singletonMap(Constants.JSON_ONE_FIELD_VALUE, "success"), HttpStatus.CONFLICT);
             //   new ResponseEntity<>(Collections.singletonMap(Constants.JSON_ONE_FIELD_VALUE, "no user found"), HttpStatus.OK);

    }


//    @PutMapping
//    public ResponseEntity updateUser(@Valid @RequestBody final Category incidentType) {
//
//        if (incidentType.getId() == null)
//            throw new MessageException("id must not be empty !");
//        Category result = categoryService.save(incidentType);
//        return result == null
//                ? new ResponseEntity<>(HttpStatus.CONFLICT)
//                : new ResponseEntity<>(result, HttpStatus.OK);
//
//    }
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
