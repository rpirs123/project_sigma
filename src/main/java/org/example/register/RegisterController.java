package org.example.register;

import org.example.User;
import org.example.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;
    private final UserRepository repository;

    public RegisterController(RegisterService registerService,UserRepository repository){
        System.out.println("RegisterController created with service: " + registerService);
        System.out.println("RegisterController created with repository: " + repository);
        this.registerService = registerService;
        this.repository = repository;
    }

    @PutMapping
    public ResponseEntity<?> newUser(@RequestBody User newUser ){
        try{
            User user = registerService.registerUser(newUser);
            System.out.println("newuser created lol  "+newUser);
            return ResponseEntity.ok(repository.save(user));
        }
        catch(Exception e){
            System.out.println("ERROR ERROR:   " + e);

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Conflict");
            errorResponse.put("message", "User already exists or violates unique constraints");

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(errorResponse);
        }
    }

    @GetMapping
    String Message(){
        return "register page ";
    }
}
