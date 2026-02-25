package com.bloste_software.remmy_server.presentation.dtos;

import com.bloste_software.remmy_server.domain.models.entities.location.Comunity;
import com.bloste_software.remmy_server.domain.models.entities.location.Province;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProvinceDTO {
    private Long id;
    private String name;
    private Long comunityId;

    public ProvinceDTO(Long id, String name, Long comunityId) {
        this.id = id;
        this.name = name;
        this.comunityId = comunityId;
    }

    public static ProvinceDTO convertToDTO(Province entity) {
        if (entity == null) return null;
        return new ProvinceDTO(entity.getId(), entity.getName(), entity.getComunity() != null ? entity.getComunity().getId() : null);
    }

    public Province toEntity() {
        Province entity = new Province();
        entity.setId(this.id);
        entity.setName(this.name);
        if (this.comunityId != null) {
            Comunity comunity = new Comunity();
            comunity.setId(this.comunityId);
            entity.setComunity(comunity);
        }
        return entity;
    }
}
