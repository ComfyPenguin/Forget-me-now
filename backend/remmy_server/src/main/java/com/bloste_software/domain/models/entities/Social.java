package com.bloste_software.domain.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

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
