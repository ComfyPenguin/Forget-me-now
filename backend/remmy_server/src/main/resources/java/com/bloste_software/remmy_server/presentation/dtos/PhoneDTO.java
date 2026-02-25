package com.bloste_software.remmy_server.presentation.dtos;

import com.bloste_software.remmy_server.domain.models.entities.contact.Phone;
import com.bloste_software.remmy_server.domain.models.entities.center.Center;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhoneDTO {
    private Long id;
    private String phone;
    private Long centerId;

    public PhoneDTO(Long id, String phone, Long centerId) {
        this.id = id;
        this.phone = phone;
        this.centerId = centerId;
    }

    public static PhoneDTO convertToDTO(Phone entity) {
        if (entity == null) return null;
        return new PhoneDTO(entity.getId(), entity.getPhone(), entity.getCenter() != null ? entity.getCenter().getId() : null);
    }

    public Phone toEntity() {
        Phone entity = new Phone();
        entity.setId(this.id);
        entity.setPhone(this.phone);
        if (this.centerId != null) {
            Center center = new Center();
            center.setId(this.centerId);
            entity.setCenter(center);
        }
        return entity;
    }
}
