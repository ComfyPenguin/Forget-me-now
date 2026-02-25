package com.bloste_software.remmy_server.presentation.dtos;

import java.time.LocalDateTime;

import com.bloste_software.remmy_server.domain.models.entities.center.Center;
import com.bloste_software.remmy_server.domain.models.entities.center.CenterType;
import com.bloste_software.remmy_server.domain.models.entities.location.Location;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CenterDTO {

    private Long id;
    private String name;
    private String address;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long typeId;
    private Integer locationId;

    public CenterDTO(Long id, String name, String address, String description, LocalDateTime createdAt, LocalDateTime updatedAt, Long typeId, Integer locationId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.typeId = typeId;
        this.locationId = locationId;
    }

    public static CenterDTO convertToDTO(Center center) {
        if (center == null) return null;

        CenterDTO dto = new CenterDTO();
        dto.setId(center.getId());
        dto.setName(center.getName());
        dto.setAddress(center.getAddress());
        dto.setDescription(center.getDescription());
        dto.setCreatedAt(center.getCreatedAt());
        dto.setUpdatedAt(center.getUpdatedAt());

        if (center.getType() != null) {
            dto.setTypeId(center.getType().getId());
        }

        if (center.getLocation() != null) {
            dto.setLocationId(center.getLocation().getId());
        }

        return dto;
    }

    public Center toEntity() {
        Center center = new Center();
        center.setId(this.id);
        center.setName(this.name);
        center.setAddress(this.address);
        center.setDescription(this.description);
        center.setCreatedAt(this.createdAt);
        center.setUpdatedAt(this.updatedAt);

        if (this.typeId != null) {
            CenterType type = new CenterType();
            type.setId(this.typeId);
            center.setType(type);
        }

        if (this.locationId != null) {
            Location location = new Location();
            location.setId(this.locationId);
            center.setLocation(location);
        }

        return center;
    }
}