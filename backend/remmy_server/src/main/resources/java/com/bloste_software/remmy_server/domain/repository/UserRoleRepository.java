package com.bloste_software.remmy_server.domain.repository;

import java.util.List;
import java.util.Optional;
import com.bloste_software.remmy_server.domain.models.entities.users.UserRole;
import com.bloste_software.remmy_server.presentation.dtos.UserRoleDTO;

public interface UserRoleRepository {
    List<UserRoleDTO> getAll();
    void save(UserRoleDTO dto);
    void saveEntity(UserRole entity);
    boolean existsById(Long id);
    UserRoleDTO getById(Long id);
    void deleteById(Long id);
    void updateById(Long id, UserRoleDTO dto);
    Optional<UserRole> findById(Long id);
}
