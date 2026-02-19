package com.bloste_software.application.usecases.user;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bloste_software.domain.repository.UserRepository;
import com.bloste_software.presentation.dtos.UserDTO;


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

