package com.back.game.backgame.note.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NoteResponse {

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("value")
    private String value;

    @JsonProperty("exam")
    private String exam;

    @JsonProperty("win")
    private Boolean win;

    public NoteResponse(String subject, String value, String exam, Boolean win) {
        this.subject = subject;
        this.value = value;
        this.exam = exam;
        this.win = win;
    }
}
