package com.back.game.backgame.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserCreateRequest {

    @JsonProperty("name")
    @NotBlank
    private String name;

    @JsonProperty("email")
    @NotBlank
    private String email;

    @JsonProperty("password")
    @NotBlank
    private String password;

    @JsonProperty("birthday")
    @NotNull
    private LocalDateTime birthday;
}

