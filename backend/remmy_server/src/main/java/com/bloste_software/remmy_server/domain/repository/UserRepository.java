package com.bloste_software.remmy_server.domain.repository;

import java.util.List;

import com.bloste_software.remmy_server.domain.models.entities.users.Users;
import com.bloste_software.remmy_server.presentation.dtos.UserDTO;


public interface UserRepository {

    // Devuelve todos los usuarios
    List<UserDTO> getAllUsers();

    // Guardar usuario
    void save(UserDTO user);

    void saveEntity(Users user);

    // Borrar usuario por email
    void deleteByEmail(String email);

    // Guarda una llista de usuarios
    void saveAll(List<UserDTO> users);

    // Verificar si un usuario ya existe por email
    boolean existsByEmail(String email);

    // Verificar si un usuario ya existe por id
    UserDTO getById(Long id);

    // Verificar si un usuario ya existe por id
    void deleteById(Long id);

    // Encontrar usuario por email
    Users findByEmail(String email);

    // Editar usuario por email
    void editByEmail(String email);

    // Editar usuario por id
    void updateById(Long id, UserDTO dto);
}
