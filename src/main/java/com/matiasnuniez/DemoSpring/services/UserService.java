package com.matiasnuniez.DemoSpring.services;

import com.matiasnuniez.DemoSpring.models.User;
import com.matiasnuniez.DemoSpring.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public String login(String email, String password) {
        User user = this.userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return Jwts.builder()
                    .setSubject(user.getEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día
                    .signWith(SignatureAlgorithm.HS256, key)
                    .compact();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
        }
    }

    public User createNewUser(User user) {
        return this.userRepository.save(user);
    }

    public String deleteUser(Long id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id inválido, no se encontró ningún usuario"));
        this.userRepository.delete(user);
        return "El usuario fue eliminado correctamente";
    }

    public User getOneUser(Long id){
        return this.userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro un user con ese id."));
    }

    public User updateOneUser(Long id, User user){
        User existUser = this.userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al buscar el usuario con id" + id));
        existUser.setEmail(user.getEmail());
        existUser.setPassword(user.getPassword());
        existUser.setName(user.getName());
        existUser.setLastName(user.getLastName());
        return this.userRepository.save(existUser);
    }

}
