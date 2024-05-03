package com.back.game.backgame.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.time.LocalDateTime;
import java.util.UUID;

public class UserResponse {

    @JsonProperty("user_id")
    private UUID userId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("birthday")
    private LocalDateTime birthday;

    public UserResponse(UUID userId, String name, String email, String password, LocalDateTime birthday) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    public static UserResponse create(UUID userId, String name, String email, String password, LocalDateTime birthday){
        return new UserResponse(userId, name, email, password, birthday);
    }
}
