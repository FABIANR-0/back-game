package com.back.game.backgame.user.controller;

import com.back.game.backgame.user.dto.UserCreateRequest;
import com.back.game.backgame.user.dto.UserResponse;
import com.back.game.backgame.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/{mail}")
    @Operation(description = "get user by mail")
    @ApiResponse(responseCode = "200", description = "success")
    public ResponseEntity<UserResponse> getUser(@Parameter(required = true, description = "mail of a user")
                                                @PathVariable("mail") String mail) {
        return new ResponseEntity<>(userService.getUserByMail(mail), HttpStatus.OK);
    }
}
