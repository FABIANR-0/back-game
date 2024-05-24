package com.back.game.backgame.note.service;

import com.back.game.backgame.note.dto.NoteCreateRequest;
import com.back.game.backgame.note.dto.NoteResponse;

import java.util.List;
import java.util.UUID;

public interface NoteService {

    void create(NoteCreateRequest request);

    List<NoteResponse> getNotesOfUser(String userId);

    List<NoteResponse> getNotesAllNotes();
}
