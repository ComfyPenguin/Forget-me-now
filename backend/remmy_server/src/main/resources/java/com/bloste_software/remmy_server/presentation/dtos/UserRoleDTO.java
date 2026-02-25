package com.bloste_software.remmy_server.presentation.dtos;

import com.bloste_software.remmy_server.domain.models.entities.users.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRoleDTO {
    private Long id;
    private String name;

    public UserRoleDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UserRoleDTO convertToDTO(UserRole entity) {
        if (entity == null) return null;
        return new UserRoleDTO(entity.getId(), entity.getName());
    }

    public UserRole toEntity() {
        UserRole entity = new UserRole();
        entity.setId(this.id);
        entity.setName(this.name);
        return entity;
    }
}
