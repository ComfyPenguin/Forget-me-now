package com.bloste_software.remmy_server.domain.models.entities.center;

import java.io.Serial;
import java.io.Serializable;

import com.bloste_software.remmy_server.domain.models.entities.contact.Social;
import com.bloste_software.remmy_server.domain.models.relationships.CenterSocialId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

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
