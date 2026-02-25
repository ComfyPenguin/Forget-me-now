package com.bloste_software.remmy_server.application.usecases.user;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bloste_software.remmy_server.domain.repository.UserRepository;
import com.bloste_software.remmy_server.presentation.dtos.UserDTO;


@Component
public class getAllUsersUseCase {

    private final UserRepository repository;

    public getAllUsersUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> execute() {
        return repository.getAllUsers();
    }
}

