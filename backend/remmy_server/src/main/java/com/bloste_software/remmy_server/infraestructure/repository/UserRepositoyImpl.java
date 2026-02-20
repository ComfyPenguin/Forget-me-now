package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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
    
}
