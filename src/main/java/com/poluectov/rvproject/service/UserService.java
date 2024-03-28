package com.poluectov.rvproject.service;

import com.poluectov.rvproject.dto.user.UserRequestTo;
import com.poluectov.rvproject.dto.user.UserResponseTo;
import com.poluectov.rvproject.model.User;
import com.poluectov.rvproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends CommonRestService<User, UserRequestTo, UserResponseTo> {

    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
    @Override
    Optional<UserResponseTo> mapResponseTo(User user) {
        return Optional.ofNullable(UserResponseTo.builder()
                .id(user.getId())
                .login(user.getLogin())
                .hashedPassword(user.getPassword()) //TODO: hash
                .firstname(user.getFirstName())
                .lastname(user.getLastName())
                .build());
    }
}
