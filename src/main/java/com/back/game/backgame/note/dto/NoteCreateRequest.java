package com.back.game.backgame.note.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class NoteCreateRequest {

    @JsonProperty("subject")
    @NotBlank
    private String subject;

    @JsonProperty("value")
    @NotBlank
    private String value;

    @JsonProperty("exam")
    @NotBlank
    private String exam;

    @JsonProperty("user_name")
    @NotNull
    private String userName;
}
