package com.matiasnuniez.DemoSpring.controller;

import com.matiasnuniez.DemoSpring.models.User;
import com.matiasnuniez.DemoSpring.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return this.userService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }

    @PostMapping("/user")
    public void newUser(@RequestBody User user) {
        this.userService.createNewUser(user);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
}
