package org.example.register;

import org.example.User;
import org.example.UserRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    User newUser(@RequestBody User newUser ){
        try{
            User user = registerService.registerUser(newUser);
            System.out.println("newuser created lol  "+newUser);
            return repository.save(newUser);
        }
        catch(Exception e){
            System.out.println("ERROR ERROR:   " + e);
        }

        return null;
    }
}
