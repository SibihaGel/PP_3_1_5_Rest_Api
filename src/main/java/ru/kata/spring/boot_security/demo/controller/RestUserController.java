package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;
import java.security.Principal;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestUserController {
    private final UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }
    @CrossOrigin
    @GetMapping("/principal")
    public ResponseEntity<User> principalInfo(Principal principal) {
        return new ResponseEntity<>(userService.findUserByName(principal.getName()), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers() {
        return new ResponseEntity<>(userService.AllUser(), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<User> userById(@PathVariable("id") int id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/new")
    public void newUser(@RequestBody User user) {
        userService.saveUser(user);
    }
    @CrossOrigin
    @PatchMapping("/{id}")
    public void editUser(@RequestBody User user) {
        userService.saveUser(user);
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }
}