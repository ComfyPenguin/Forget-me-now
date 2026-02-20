package com.bloste_software.remmy_server.domain.models.relationships;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class CenterSocialId implements Serializable {

    @Column(name = "id_center")
    private Long centerId;

    @Column(name = "id_social")
    private Long socialId;
}
