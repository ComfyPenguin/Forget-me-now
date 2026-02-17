package com.bloste_software.domain.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table
public class CenterCharacteristic implements Serializable {
    @Serial
    private static final Long serialVersionUID=17L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_center", nullable = false)
    private Center center;
}
