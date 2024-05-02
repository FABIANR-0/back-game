package com.back.game.backgame.note.controller;

import com.back.game.backgame.note.dto.NoteCreateRequest;
import com.back.game.backgame.note.service.NoteService;
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
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @PostMapping("/")
    @Operation(description = "save a note of user")
    @ApiResponse(responseCode = "201", description = "created")
    public ResponseEntity<HttpStatus> saveNote(@RequestBody @Valid NoteCreateRequest request) {
        noteService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
