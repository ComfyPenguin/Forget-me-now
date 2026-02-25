package com.bloste_software.remmy_server.application.usecases.user;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bloste_software.remmy_server.domain.models.entities.users.Users;
import com.bloste_software.remmy_server.domain.repository.UserRepository;

@Component
public class UpdateUserByEmailUseCase {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder; 

    public UpdateUserByEmailUseCase(UserRepository repository,
                                    PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users execute(String email, String newUsername, String newPassword) {

        Users user = repository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found: " + email);
        }

        if (newUsername != null && !newUsername.isBlank()) {
            user.setUsername(newUsername);
        }

        if (newPassword != null && !newPassword.isBlank()) {
            String hashed = passwordEncoder.encode(newPassword); 
            user.setPasswordHashed(hashed);
        }

        user.setUpdatedAt(LocalDateTime.now());

        repository.saveEntity(user);

        return user;
    }
}