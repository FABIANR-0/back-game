package com.back.game.backgame.user.service.impl;

import com.back.game.backgame.user.dto.UserCreateRequest;
import com.back.game.backgame.user.entity.User;
import com.back.game.backgame.user.repository.UserRepository;
import com.back.game.backgame.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserCreateRequest request) {
        User user = User.create(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                request.getBirthday()
        );
        userRepository.save(user);
    }
}
