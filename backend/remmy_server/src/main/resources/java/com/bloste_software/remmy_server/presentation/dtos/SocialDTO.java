package com.bloste_software.remmy_server.presentation.dtos;

import com.bloste_software.remmy_server.domain.models.entities.contact.Social;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SocialDTO {
    private Long id;
    private String name;

    public SocialDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SocialDTO convertToDTO(Social entity) {
        if (entity == null) return null;
        return new SocialDTO(entity.getId(), entity.getName());
    }

    public Social toEntity() {
        Social entity = new Social();
        entity.setId(this.id);
        entity.setName(this.name);
        return entity;
    }
}
