package com.bloste_software.domain.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table
public class Center implements Serializable {
    @Serial
    private static final Long serialVersionUID=17L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_center")
    private Long id;

    @Column
    private String name;

    @Column
    private String street;

    @Column
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relaciones
    @OneToMany(mappedBy = "center")
    private List<CenterSocial> socials;

    @ManyToOne
    @JoinColumn(name = "id_type", nullable = true)
    private CenterType type;

    @ManyToOne
    @JoinColumn(name = "id_location", nullable = true)
    private Location location;
}
