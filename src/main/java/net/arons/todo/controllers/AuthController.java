package net.arons.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import net.arons.todo.controllers.api.AuthApi;
import net.arons.todo.dto.UserDto;
import net.arons.todo.services.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController implements AuthApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserDto> loginUser(UserDto user) {
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
    }
}
