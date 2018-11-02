package just.fo.fun.incident.Controller;

import just.fo.fun.entities.Incident;
import just.fo.fun.entities.Post;

import just.fo.fun.incident.model.IncidentDto;
import just.fo.fun.incident.service.IncidentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/incident")
public class IncidentController {
    @Autowired
    private IncidentService postService;

/*


    @PostMapping
    public ResponseEntity insertUser(@Valid @RequestBody final UserDto userDto) {

        if (userDto.getId() != null)
            throw new MessageException("id must be empty !");

        User user = new User();
        Utils.copyProperties(userDto, user);
        User resultUser = null;
        try {
            resultUser = userService.save(user);
        }catch (Exception e){
            throw new MessageException("ffffffff" + e.getMessage());
        }
        return resultUser == null
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(Utils.copyProperties(resultUser, new UserDto()), HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity updateUser(@Valid @RequestBody final UserDto userDto) {

        if (userDto.getId() == null)
            throw new MessageException("id must not be empty !");
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        User resultUser = userService.save(user);
        return resultUser == null
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(resultUser, HttpStatus.OK);

    }

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


    @GetMapping
    public ResponseEntity getIncidents( ) {

        List<Incident> incidents = postService.getAll();
        List<IncidentDto> incidentDtos = incidents.stream().map(IncidentDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(incidentDtos, HttpStatus.OK);

    }


}
