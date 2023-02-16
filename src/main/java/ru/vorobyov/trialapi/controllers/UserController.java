package ru.vorobyov.trialapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vorobyov.trialapi.entities.User;
import ru.vorobyov.trialapi.services.interfaces.UserService;

@RestController
@RequestMapping({ApiPaths.USER_URL})
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody User user) {
        long id = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}
