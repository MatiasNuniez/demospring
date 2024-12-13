package com.matiasnuniez.DemoSpring.services;

import com.matiasnuniez.DemoSpring.models.User;
import com.matiasnuniez.DemoSpring.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User createNewUser(User user){
        return this.userRepository.save(user);
    }

    public String deleteUser (Long id){
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id invalido, no se encontro ningun usuario"));
        return ("El usuario fue eliminado correctamente");
    }

}
