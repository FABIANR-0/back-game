package com.back.game.backgame.note.service.impl;

import com.back.game.backgame.common.exception_handler.ResourceNotFoundException;
import com.back.game.backgame.note.dto.NoteCreateRequest;
import com.back.game.backgame.note.dto.NoteResponse;
import com.back.game.backgame.note.entity.Note;
import com.back.game.backgame.note.repository.NoteRepository;
import com.back.game.backgame.note.service.NoteService;
import com.back.game.backgame.user.entity.User;
import com.back.game.backgame.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;


    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    @Override
    public void create(NoteCreateRequest request) {
        Note note = Note.crete(request.getSubject(),
                request.getValue(),
                request.getUserName(),
                request.getExam()
        );
        noteRepository.save(note);
    }

    @Override
    public List<NoteResponse> getNotesOfUser(String userName) {
        return noteRepository.getAllNotesOfUser(userName);
    }

    @Override
    public List<NoteResponse> getNotesAllNotes() {
        return noteRepository.getAllNotes();
    }
}
