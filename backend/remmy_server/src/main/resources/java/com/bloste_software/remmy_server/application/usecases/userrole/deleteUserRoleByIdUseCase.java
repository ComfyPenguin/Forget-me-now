package com.bloste_software.remmy_server.application.usecases.userrole;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.UserRoleRepository;

@Service
public class deleteUserRoleByIdUseCase {
    private final UserRoleRepository repository;
    public deleteUserRoleByIdUseCase(UserRoleRepository repository) { this.repository = repository; }
    public void execute(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new RuntimeException("UserRole not found");
    }
}
