package com.techwithfathi.bankapi.controllers;

import com.techwithfathi.bankapi.dto.user.UserRegisterRequestDto;
import com.techwithfathi.bankapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/register")
public class UserController {
    UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    ResponseEntity<String> registerUser(@RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        return ResponseEntity
                .status(OK)
                .body(userService.registerUser(userRegisterRequestDto));
    }
}
