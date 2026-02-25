package com.bloste_software.remmy_server.presentation.dtos;

import java.time.LocalDateTime;

import com.bloste_software.remmy_server.domain.models.entities.users.Users;
import com.bloste_software.remmy_server.domain.models.entities.users.UserRole;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;                 // null al crear
    private String username;
    private String email;
    private String password;         // solo para creación/actualización
    private Long roleId;             // evitamos exponer el objeto Role completo
    private LocalDateTime createdAt; // solo lectura
    private LocalDateTime updatedAt; // solo lectura

    public UserDTO() {}

    // Constructor útil para respuestas
    public UserDTO(Long id, String username, String email, Long roleId,
                   LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roleId = roleId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // ENTITY → DTO
    public static UserDTO convertToDTO(Users user) {
        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());

        if (user.getRole() != null) {
            dto.setRoleId(user.getRole().getId());
        }

        // password nunca se expone
        return dto;
    }

    // DTO → ENTITY
    public Users toEntity() {
        Users user = new Users();
        user.setId(this.id); // útil para updates
        user.setUsername(this.username);
        user.setEmail(this.email);

        // el password llega en plano → se encripta en el service
        if (this.password != null) {
            user.setPasswordHashed(this.password);
        }

        // el role se asigna en el service buscando por ID
        if (this.roleId != null) {
            UserRole role = new UserRole();
            role.setId(this.roleId);
            user.setRole(role);
        }

        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    
}
