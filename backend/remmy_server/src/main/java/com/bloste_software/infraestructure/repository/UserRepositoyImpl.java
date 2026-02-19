package com.bloste_software.infraestructure.repository;

import java.util.List;
import java.util.stream.Collectors;

import com.bloste_software.domain.models.entities.User;
import com.bloste_software.domain.repository.UserRepository;
import com.bloste_software.infraestructure.repository.jpa.UserJpaRepository;
import com.bloste_software.presentation.dtos.UserDTO;

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
    public void deleteByEmail(String email) {
        jpaRepository.deleteByEmail(email);
    }

    @Override
    public void saveAll(List<UserDTO> users) {
        List<User> entities = users.stream()
                .map(UserDTO::toEntity)
                .collect(Collectors.toList());
        jpaRepository.saveAll(entities);
    }

    @Override
    public void existsByEmail(String email) {
        jpaRepository.existsByEmail(email);
    }

    @Override
    public void findByEmail(String email) {
        jpaRepository.findByEmail(email);
    }

	@Override
	public void editByEmail(String email) {
        jpaRepository.editByEmail(email);
	}
    
}
