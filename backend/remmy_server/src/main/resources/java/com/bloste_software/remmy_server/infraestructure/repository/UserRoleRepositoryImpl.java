package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.entities.users.UserRole;
import com.bloste_software.remmy_server.domain.repository.UserRoleRepository;
import com.bloste_software.remmy_server.infraestructure.repository.jpa.UserRoleJpaRepository;
import com.bloste_software.remmy_server.presentation.dtos.UserRoleDTO;

@Service
public class UserRoleRepositoryImpl implements UserRoleRepository {
    private final UserRoleJpaRepository jpaRepository;

    public UserRoleRepositoryImpl(UserRoleJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<UserRoleDTO> getAll() {
        return jpaRepository.findAll().stream()
                .map(UserRoleDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void save(UserRoleDTO dto) {
        jpaRepository.save(dto.toEntity());
    }

    @Override
    public void saveEntity(UserRole entity) {
        jpaRepository.save(entity);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public UserRoleDTO getById(Long id) {
        return jpaRepository.findById(id).map(UserRoleDTO::convertToDTO).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, UserRoleDTO dto) {
        UserRole entity = jpaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("UserRole not found"));
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        jpaRepository.save(entity);
    }

    @Override
    public Optional<UserRole> findById(Long id) {
        return jpaRepository.findById(id);
    }
}
