package com.matiasnuniez.DemoSpring.controller;

import com.matiasnuniez.DemoSpring.models.User;
import com.matiasnuniez.DemoSpring.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void newUser (@RequestBody User user){
        this.userService.createNewUser(user);
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }
}
