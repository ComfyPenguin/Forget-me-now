package com.bloste_software.remmy_server.presentation.dtos;

import com.bloste_software.remmy_server.domain.models.entities.location.Comunity;
import com.bloste_software.remmy_server.domain.models.entities.location.Region;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComunityDTO {
    private Long id;
    private String name;
    private Long regionId;

    public ComunityDTO(Long id, String name, Long regionId) {
        this.id = id;
        this.name = name;
        this.regionId = regionId;
    }

    public static ComunityDTO convertToDTO(Comunity entity) {
        if (entity == null) return null;
        return new ComunityDTO(entity.getId(), entity.getName(), entity.getRegion() != null ? entity.getRegion().getId() : null);
    }

    public Comunity toEntity() {
        Comunity entity = new Comunity();
        entity.setId(this.id);
        entity.setName(this.name);
        if (this.regionId != null) {
            Region region = new Region();
            region.setId(this.regionId);
            entity.setRegion(region);
        }
        return entity;
    }
}
