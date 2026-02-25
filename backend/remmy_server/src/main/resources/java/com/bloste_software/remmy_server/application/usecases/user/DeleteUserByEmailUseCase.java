package com.bloste_software.remmy_server.application.usecases.user;

import org.springframework.stereotype.Component;
import com.bloste_software.remmy_server.domain.repository.UserRepository;

@Component
public class DeleteUserByEmailUseCase {

    private final UserRepository repository;

    public DeleteUserByEmailUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String email) {
        if (!repository.existsByEmail(email)) {
            throw new RuntimeException("User with email " + email + " does not exist.");
        }

        repository.deleteByEmail(email);
    }
}