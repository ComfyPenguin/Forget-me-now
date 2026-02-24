package com.bloste_software.remmy_server.application.usecases.user;

import org.springframework.stereotype.Component;
import com.bloste_software.remmy_server.domain.repository.UserRepository;

@Component
public class DeleteUserByIdUseCase {

    private final UserRepository repository;

    public DeleteUserByIdUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteById(id);
    }
}
