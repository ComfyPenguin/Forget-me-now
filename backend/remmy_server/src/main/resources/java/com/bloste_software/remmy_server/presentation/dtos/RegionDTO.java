package com.bloste_software.remmy_server.presentation.dtos;

import com.bloste_software.remmy_server.domain.models.entities.location.Region;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegionDTO {
    private Long id;
    private String name;
    public RegionDTO(Long id, String name) { this.id = id; this.name = name; }
    public static RegionDTO convertToDTO(Region entity) {
        if (entity == null) return null;
        return new RegionDTO(entity.getId(), entity.getName());
    }
    public Region toEntity() {
        Region entity = new Region();
        entity.setId(this.id);
        entity.setName(this.name);
        return entity;
    }
}
