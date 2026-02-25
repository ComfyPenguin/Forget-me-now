package com.bloste_software.remmy_server.application.usecases.user;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bloste_software.remmy_server.domain.repository.UserRepository;
import com.bloste_software.remmy_server.presentation.dtos.UserDTO;


@Component
public class getUserByIdUseCase {

    private final UserRepository repository;

    public getUserByIdUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public UserDTO execute(Long id) {
        return repository.getById(id);
    }
}

