package com.bloste_software.domain.repository;

import java.util.List;

import com.bloste_software.presentation.dtos.UserDTO;



public interface UserRepository {

    // Devuelve todos los usuarios
    List<UserDTO> getAllUsers();

    // Guardar usuario
    void save(UserDTO user);

    // Borrar usuario por email
    void deleteByEmail(String email);

    // Guarda una llista de usuarios
    void saveAll(List<UserDTO> users);

    // Verificar si un usuario ya existe por email
    void existsByEmail(String email);

    // Encontrar usuario por email
    void findByEmail(String email);

    // Editar usuario por email
    void editByEmail(String email);
}
