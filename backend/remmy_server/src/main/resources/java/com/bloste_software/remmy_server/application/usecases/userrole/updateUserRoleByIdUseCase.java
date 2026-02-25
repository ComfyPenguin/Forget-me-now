package com.bloste_software.remmy_server.application.usecases.userrole;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.UserRoleRepository;
import com.bloste_software.remmy_server.presentation.dtos.UserRoleDTO;

@Service
public class updateUserRoleByIdUseCase {
    private final UserRoleRepository repository;
    public updateUserRoleByIdUseCase(UserRoleRepository repository) { this.repository = repository; }
    public void execute(Long id, UserRoleDTO dto) {
        if (repository.existsById(id)) repository.updateById(id, dto);
        else throw new RuntimeException("UserRole not found");
    }
}
