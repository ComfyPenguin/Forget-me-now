package com.bloste_software.domain.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "center_social")
public class CenterSocial implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_center", nullable = false)
    private Center center;

    @ManyToOne
    @JoinColumn(name = "id_social", nullable = false)
    private Social social;

    @Column(nullable = false)
    private String link;
}
