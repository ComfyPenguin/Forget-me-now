package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bloste_software.remmy_server.domain.models.entities.users.UserRole;
import com.bloste_software.remmy_server.domain.models.entities.users.Users;
import com.bloste_software.remmy_server.domain.repository.UserRepository;
import com.bloste_software.remmy_server.infraestructure.repository.jpa.UserJpaRepository;
import com.bloste_software.remmy_server.presentation.dtos.UserDTO;

@Service
public class UserRepositoyImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;

    public UserRepositoyImpl(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return jpaRepository.findAll()
                .stream()
                .map(UserDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void save(UserDTO userDTO) {
        jpaRepository.save(userDTO.toEntity());
    }

    @Override
    public void saveEntity(Users user) {
        jpaRepository.save(user);
    }

    @Override
    public void deleteByEmail(String email) {
        jpaRepository.deleteByEmail(email);
    }

    @Override
    public void saveAll(List<UserDTO> users) {
        List<Users> entities = users.stream()
                .map(UserDTO::toEntity)
                .collect(Collectors.toList());
        jpaRepository.saveAll(entities);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

    @Override
    public Users findByEmail(String email) {
        return jpaRepository.findByEmail(email);
    }

	@Override
	public void editByEmail(String email) {
        jpaRepository.existsByEmail(email);
	}

    @Override
    public UserDTO getById(Long id) {
        return jpaRepository.findById(id).map(UserDTO::convertToDTO).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

   @Override
    public void updateById(Long id, UserDTO dto) {
        Users entity = jpaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Username
        if (dto.getUsername() != null) {
            entity.setUsername(dto.getUsername());
        }

        // Email
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }

        // Password → se encripta con BCrypt
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            entity.setPasswordHashed(passwordEncoder.encode(dto.getPassword()));
        }

        // Role
        if (dto.getRoleId() != null) {
            UserRole role = new UserRole();
            role.setId(dto.getRoleId());
            entity.setRole(role);
        }

        // updatedAt
        entity.setUpdatedAt(java.time.LocalDateTime.now());

        jpaRepository.save(entity);
    }
    
}
