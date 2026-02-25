package com.bloste_software.remmy_server.application.usecases.user;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bloste_software.remmy_server.domain.models.entities.users.Users;
import com.bloste_software.remmy_server.domain.models.entities.users.UserRole;
import com.bloste_software.remmy_server.domain.repository.UserRepository;
import com.bloste_software.remmy_server.presentation.dtos.UserDTO;

@Component
public class UpdateUserByIdUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UpdateUserByIdUseCase(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean execute(Long id, UserDTO dto) {

        Users user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

        // Username
        if (dto.getUsername() != null && !dto.getUsername().isBlank()) {
            user.setUsername(dto.getUsername());
        }

        // Email
        if (dto.getEmail() != null && !dto.getEmail().isBlank()) {
            user.setEmail(dto.getEmail());
        }

        // Password → ENCRIPTAR AQUÍ
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            String hashed = passwordEncoder.encode(dto.getPassword());
            user.setPasswordHashed(hashed);
        }

        // Role
        if (dto.getRoleId() != null) {
            UserRole role = new UserRole();
            role.setId(dto.getRoleId());
            user.setRole(role);
        }

        // Timestamp
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.saveEntity(user);

        return true;
    }
}