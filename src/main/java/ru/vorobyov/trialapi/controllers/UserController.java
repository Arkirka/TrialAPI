package ru.vorobyov.trialapi.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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
    @ResponseStatus(HttpStatus.CREATED)
    public long createUser(@RequestBody User user) {
        if (user == null)
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "User is null");
        try{
            return userService.createUser(user);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
