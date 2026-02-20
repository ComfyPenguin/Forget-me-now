package com.bloste_software.remmy_server.application.usecases.user;
import org.springframework.stereotype.Component;

import com.bloste_software.remmy_server.domain.repository.UserRepository;
import com.bloste_software.remmy_server.presentation.dtos.UserDTO;

@Component
public class postUserUseCase {
    
    private final UserRepository userRepository;

    public postUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(UserDTO dto) {
        userRepository.save(dto);
    }
}
