package com.bloste_software.remmy_server.presentation.dtos;

import com.bloste_software.remmy_server.domain.models.entities.center.CenterType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CenterTypeDTO {

    private Long id;
    private String name;

    public CenterTypeDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CenterTypeDTO convertToDTO(CenterType entity) {
        if (entity == null) return null;
        return new CenterTypeDTO(entity.getId(), entity.getName());
    }

    public CenterType toEntity() {
        CenterType entity = new CenterType();
        entity.setId(this.id);
        entity.setName(this.name);
        return entity;
    }
}
