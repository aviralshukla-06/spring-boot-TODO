package com.aviral.myFirstDocumentation.controller;

import com.aviral.myFirstDocumentation.models.User;
import com.aviral.myFirstDocumentation.services.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){

        return userServices.registerUser(user);

    }

    @PostMapping("/login")
    public User login(@RequestBody User user){

        return userServices.loginUser(user);

    }


}
