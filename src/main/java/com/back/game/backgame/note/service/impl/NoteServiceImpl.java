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

    private final UserRepository userRepository;

    public NoteServiceImpl(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void create(NoteCreateRequest request) {
        Note note = Note.crete(request.getSubject(),
                request.getValue(),
                request.getExam()
        );
        User user = userRepository.findById(request.getUserId()).orElseThrow(()-> new ResourceNotFoundException("el usuario no existe"));
        note.addUser(user);
        noteRepository.save(note);
    }

    @Override
    public List<NoteResponse> getNotesOfUser(UUID userId) {
        return noteRepository.getAllNotesOfUser(userId);
    }

    @Override
    public List<NoteResponse> getNotesAllNotes() {
        return noteRepository.getAllNotes();
    }
}
