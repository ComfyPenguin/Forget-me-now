package com.bloste_software.remmy_server.presentation.dtos;

import com.bloste_software.remmy_server.domain.models.entities.location.City;
import com.bloste_software.remmy_server.domain.models.entities.location.Province;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CityDTO {
    private Long id;
    private String name;
    private Integer INE;
    private Long provinceId;

    public CityDTO(Long id, String name, Integer INE, Long provinceId) {
        this.id = id;
        this.name = name;
        this.INE = INE;
        this.provinceId = provinceId;
    }

    public static CityDTO convertToDTO(City entity) {
        if (entity == null) return null;
        return new CityDTO(entity.getId(), entity.getName(), entity.getINE(), entity.getProvince() != null ? entity.getProvince().getId() : null);
    }

    public City toEntity() {
        City entity = new City();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setINE(this.INE);
        if (this.provinceId != null) {
            Province province = new Province();
            province.setId(this.provinceId);
            entity.setProvince(province);
        }
        return entity;
    }
}
