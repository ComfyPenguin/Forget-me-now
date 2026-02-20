package com.bloste_software.remmy_server.application.usecases.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bloste_software.remmy_server.domain.models.entities.users.Users;
import com.bloste_software.remmy_server.domain.repository.UserRepository;
import com.bloste_software.remmy_server.presentation.dtos.UserDTO;

@Component
public class postUserUseCase {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // 👈 nou

    public postUserUseCase(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void execute(UserDTO dto) {

        Users user = dto.toEntity();

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            String hashed = passwordEncoder.encode(dto.getPassword());
            user.setPasswordHashed(hashed);
        }

        userRepository.saveEntity(user);
    }
}