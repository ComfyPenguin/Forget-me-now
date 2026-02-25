package com.bloste_software.remmy_server.application.usecases.userrole;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.UserRoleRepository;
import com.bloste_software.remmy_server.presentation.dtos.UserRoleDTO;

@Service
public class postUserRoleUseCase {
    private final UserRoleRepository repository;
    public postUserRoleUseCase(UserRoleRepository repository) { this.repository = repository; }
    public void execute(UserRoleDTO dto) { repository.save(dto); }
}
