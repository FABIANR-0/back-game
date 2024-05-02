package com.back.game.backgame.note.entity;

import com.back.game.backgame.common.util.AuditEntity;
import com.back.game.backgame.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "note", schema = "main")
public class Note extends AuditEntity {

    @Id
    @GeneratedValue
    @Column(name = "note_id", unique = true)
    private UUID noteId;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "exam", nullable = false)
    private String exam;

    @Column(name = "win", nullable = false)
    private Boolean win;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Note(){}

    public Note(String subject, String value, String exam, Boolean win) {
        this.subject = subject;
        this.value = value;
        this.exam = exam;
        this.win = win ;
    }

    public  static  Note crete(String subject, String value, String exam){
        return new Note(subject, value, exam, Double.parseDouble(value)>= 3);
    }

    public void addUser(User user){
        this.user = user;
    }
}
