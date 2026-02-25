package com.bloste_software.remmy_server.presentation.dtos;

import com.bloste_software.remmy_server.domain.models.entities.location.Location;
import com.bloste_software.remmy_server.domain.models.entities.location.City;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationDTO {
    private Integer id;
    private Integer postalCode;
    private String name;
    private Long cityId;

    public LocationDTO(Integer id, Integer postalCode, String name, Long cityId) {
        this.id = id;
        this.postalCode = postalCode;
        this.name = name;
        this.cityId = cityId;
    }

    public static LocationDTO convertToDTO(Location entity) {
        if (entity == null) return null;
        return new LocationDTO(entity.getId(), entity.getPostalCode(), entity.getName(), entity.getIdCity() != null ? entity.getIdCity().getId() : null);
    }

    public Location toEntity() {
        Location entity = new Location();
        entity.setId(this.id);
        entity.setPostalCode(this.postalCode);
        entity.setName(this.name);
        if (this.cityId != null) {
            City city = new City();
            city.setId(this.cityId);
            entity.setIdCity(city);
        }
        return entity;
    }
}
