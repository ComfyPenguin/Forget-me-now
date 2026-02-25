package com.bloste_software.remmy_server.application.usecases.userrole;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.UserRoleRepository;
import com.bloste_software.remmy_server.presentation.dtos.UserRoleDTO;

@Service
public class getAllUserRolesUseCase {
    private final UserRoleRepository repository;
    public getAllUserRolesUseCase(UserRoleRepository repository) { this.repository = repository; }
    public List<UserRoleDTO> execute() { return repository.getAll(); }
}
