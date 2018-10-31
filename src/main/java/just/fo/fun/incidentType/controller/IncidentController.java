package just.fo.fun.incidentType.controller;

import just.fo.fun.entities.IncidentType;
import just.fo.fun.incidentType.service.IncidentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/incident")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

//    @PostMapping
//    public ResponseEntity insertUser(@Valid @RequestBody final Category category) {
//
//        if (category.getId() != null)
//            throw new MessageException("id must be empty !");
//
//        Category result;
//        try {
//            result = categoryService.save(category);
//        }catch (Exception e){
//            throw new MessageException("can not save incidentType" + e.getMessage());
//        }
//        return result == null
//                ? new ResponseEntity<>(HttpStatus.CONFLICT)
//                : new ResponseEntity<>(result, HttpStatus.OK);
//
//    }

//    @PutMapping
//    public ResponseEntity updateUser(@Valid @RequestBody final Category category) {
//
//        if (category.getId() == null)
//            throw new MessageException("id must not be empty !");
//        Category result = categoryService.save(category);
//        return result == null
//                ? new ResponseEntity<>(HttpStatus.CONFLICT)
//                : new ResponseEntity<>(result, HttpStatus.OK);
//
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity getUser(@PathVariable final Long id) {
//
//        UserDto userDto = new UserDto();
//        User user = userService.findOne(id);
//
//        BeanUtils.copyProperties(user, userDto);
//        return userDto == null
//                ? new ResponseEntity<>(HttpStatus.CONFLICT)
//                : new ResponseEntity<>(userDto, HttpStatus.OK);
//
//    }

    @GetMapping("/")
    public ResponseEntity getIncidents() {

        List<IncidentType> incidentTypes = incidentService.findAll();

        return incidentTypes == null
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(incidentTypes, HttpStatus.OK);
    }
/*
    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable final Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
*/

}
