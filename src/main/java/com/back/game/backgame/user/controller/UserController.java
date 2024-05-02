package com.back.game.backgame.user.controller;

import com.back.game.backgame.user.dto.UserCreateRequest;
import com.back.game.backgame.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/")
    @Operation(description = "save a new user")
    @ApiResponse(responseCode = "201", description = "created")
    public ResponseEntity<HttpStatus> saveNote(@RequestBody @Valid UserCreateRequest request) {
        userService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
