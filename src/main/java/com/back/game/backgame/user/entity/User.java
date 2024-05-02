package com.back.game.backgame.user.entity;

import com.back.game.backgame.common.util.AuditEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user", schema = "main")
public class User extends AuditEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id", unique = true, nullable = false)
    private UUID userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "birthday", nullable = false)
    private LocalDateTime birthday;

    public User(){}

    public User(String name, String email, String password, LocalDateTime birthday) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    public static User create(String name, String email, String password, LocalDateTime birthday) {
        return new User(name, email, password, birthday);
    }

}
