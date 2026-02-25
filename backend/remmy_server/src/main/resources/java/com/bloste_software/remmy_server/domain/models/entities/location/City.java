package com.bloste_software.remmy_server.domain.models.entities.location;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
public class City implements Serializable{
    @Serial
    private static final Long serialVersionUID=17L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city")
    private Long id;

    @Column
    private String name;

    @Column
    private Integer INE;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_province", nullable = false)
    private Province province;
    
}
