package com.bloste_software.remmy_server.presentation.dtos;

import com.bloste_software.remmy_server.domain.models.entities.center.CenterCharacteristic;
import com.bloste_software.remmy_server.domain.models.entities.center.Center;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CenterCharacteristicDTO {
    private Long id;
    private String name;
    private Long centerId;

    public CenterCharacteristicDTO(Long id, String name, Long centerId) {
        this.id = id;
        this.name = name;
        this.centerId = centerId;
    }

    public static CenterCharacteristicDTO convertToDTO(CenterCharacteristic entity) {
        if (entity == null) return null;
        return new CenterCharacteristicDTO(entity.getId(), entity.getName(), entity.getCenter() != null ? entity.getCenter().getId() : null);
    }

    public CenterCharacteristic toEntity() {
        CenterCharacteristic entity = new CenterCharacteristic();
        entity.setId(this.id);
        entity.setName(this.name);
        if (this.centerId != null) {
            Center center = new Center();
            center.setId(this.centerId);
            entity.setCenter(center);
        }
        return entity;
    }
}
