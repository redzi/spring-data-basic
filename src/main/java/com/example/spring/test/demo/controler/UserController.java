package com.example.spring.test.demo.controler;

import com.example.spring.test.demo.model.User;
import com.example.spring.test.demo.model.UserId;
import com.example.spring.test.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/getById", produces = "application/json")
    public ResponseEntity<User> getUserById(@RequestBody UserId id)
    {
        Optional<User> userOp = userRepository.findById(id);
        return userOp.map(user -> new ResponseEntity(user, HttpStatus.OK))
              .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping(produces = "application/json")
    public Iterable<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    @PostMapping(produces = "application/json")
    public User saveUser(@RequestBody @Valid User user)
    {
        return userRepository.save(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody User user)
    {
        userRepository.delete(user);
    }
}
