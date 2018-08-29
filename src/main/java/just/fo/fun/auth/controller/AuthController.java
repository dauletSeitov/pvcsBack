package just.fo.fun.auth.controller;


import com.sun.org.apache.bcel.internal.classfile.Code;
import just.fo.fun.AuthDto;
import just.fo.fun.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/def")
public class AuthController {

    @Autowired
    private AuthService authService;



    @PostMapping
    public ResponseEntity<Code> insertDictionary(@RequestBody final AuthDto authDto) {

        Long res = authService.create(authDto);

        return res == 0
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(HttpStatus.CREATED);

    }

//    @GetMapping
//    public ResponseEntity<List<AuthDto>> getAll() {
//    }//
//        List<AuthDto> result = authService.getAll();
//        return result == null
//                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
//                : new ResponseEntity<>(result, HttpStatus.OK);



    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/mal")
    String helliio() {
        return "Hello, "  + "!";
    }
}
