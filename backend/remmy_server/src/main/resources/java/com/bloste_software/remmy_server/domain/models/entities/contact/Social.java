package com.bloste_software.remmy_server.domain.models.entities.contact;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.bloste_software.remmy_server.domain.models.entities.center.CenterSocial;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
public class Social implements Serializable {
    @Serial
    private static final Long serialVersionUID=17L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_social")
    private Long id;

    @Column(name = "img_url")
    private String imgUrl;

    @Column
    private String name;

    // Relaciones
    @OneToMany(mappedBy = "social")
    private List<CenterSocial> centers;
}
