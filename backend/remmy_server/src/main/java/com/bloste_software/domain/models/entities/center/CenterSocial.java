package com.bloste_software.domain.models.entities.center;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

import com.bloste_software.domain.models.entities.contact.Social;
import com.bloste_software.domain.models.relationships.CenterSocialId;

@Data
@NoArgsConstructor
@Entity
@Table(name = "center_social")
public class CenterSocial implements Serializable {

    @Serial
    private static final Long serialVersionUID = 1L;

    @EmbeddedId
    private CenterSocialId id;

    @Column(nullable = false)
    private String link;

    // Relaciones
    @ManyToOne
    @MapsId("centerId")
    @JoinColumn(name = "id_center")
    private Center center;

    @ManyToOne
    @MapsId("socialId")
    @JoinColumn(name = "id_social")
    private Social social;
}
