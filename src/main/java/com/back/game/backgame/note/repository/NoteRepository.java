package com.back.game.backgame.note.repository;

import com.back.game.backgame.note.dto.NoteResponse;
import com.back.game.backgame.note.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {

    @Query("SELECT new com.back.game.backgame.note.dto.NoteResponse(n.subject, n.value, n.exam, n.win) FROM Note n " +
            "WHERE n.user.userId = :userId")
    List<NoteResponse> getAllNotesOfUser(UUID userId);
}
