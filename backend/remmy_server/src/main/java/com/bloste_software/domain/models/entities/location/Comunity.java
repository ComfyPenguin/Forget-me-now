package com.bloste_software.domain.models.entities.location;

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
public class Comunity implements Serializable {
    @Serial
    private static final Long serialVersionUID=17L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comunity")
    private Long id;

    @Column
    private String name;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_region", nullable = false)
    private Region region;
}
