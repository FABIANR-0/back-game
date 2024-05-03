package com.back.game.backgame.user.service;

import com.back.game.backgame.user.dto.UserCreateRequest;
import com.back.game.backgame.user.dto.UserResponse;

public interface UserService {

    void create(UserCreateRequest request);

    UserResponse getUserByMail(String mail);
}
