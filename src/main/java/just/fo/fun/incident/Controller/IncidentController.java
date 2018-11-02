package just.fo.fun.incident.Controller;

import just.fo.fun.area.service.AreaService;
import just.fo.fun.entities.Incident;
import just.fo.fun.exception.MessageException;
import just.fo.fun.incident.model.IncidentDto;
import just.fo.fun.incident.service.IncidentService;
import just.fo.fun.incidentType.service.IncidentTypeService;
import just.fo.fun.vehicleType.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/incident")
public class IncidentController {
    @Autowired
    private IncidentService incidentService;
    @Autowired
    private IncidentTypeService incidentTypeService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private AreaService areaService;


    @PostMapping
    public ResponseEntity insertIncident(@Valid @RequestBody final IncidentDto incidentDto) {

        if (incidentDto.getId() != null)
            throw new MessageException("id must be empty !");

        if (incidentDto.getIncidentTypeId() == null)
            throw new MessageException("getAtachmentId must not be empty !");

        if (incidentDto.getAreaId() == null)
            throw new MessageException("getAreaId must not be empty !");

        if (incidentDto.getVehicleTypeId() == null)
            throw new MessageException("getVehicleTypeId must not be empty !");

        Incident incident = new Incident();
        incident.setName(incidentDto.getName());
        incident.setDescription(incidentDto.getDescription());
        incident.setDangerLevel(incidentDto.getDangerLevel());
        incident.setIncidentType(incidentTypeService.findOne(incidentDto.getIncidentTypeId()));
        incident.setVehicleType(vehicleService.findOne(incidentDto.getVehicleTypeId()));
        incident.setAtachment(incidentDto.getAtachment());
        incident.setArea(areaService.findOne(incidentDto.getAreaId()));


        Incident resultUser = null;
        try {
            resultUser = incidentService.save(incident);
        }catch (Exception e){
            throw new MessageException("ffffffff" + e.getMessage());
        }
        return resultUser == null
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(resultUser, HttpStatus.OK);

    }
/*
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

        List<Incident> incidents = incidentService.getAll();
        List<IncidentDto> incidentDtos = incidents.stream().map(IncidentDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(incidentDtos, HttpStatus.OK);

    }


}
