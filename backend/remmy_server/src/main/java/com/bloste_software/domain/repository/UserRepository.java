package com.bloste_software.domain.repository;

import java.util.List;

import com.bloste_software.presentation.dtos.UserDTO;



public interface UserRepository {

    // Retorna totes les categories
    List<UserDTO> findAllDTO();

    void save(UserDTO user);

    void deleteById(String email);

    // Guarda una llista de categories
    void saveAll(List<UserDTO> users);


    void existsByEmail(String email);
    void findByEmail(String email);
}
