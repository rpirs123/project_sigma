package org.example.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login(){
        return "login page lol";
    }

}
