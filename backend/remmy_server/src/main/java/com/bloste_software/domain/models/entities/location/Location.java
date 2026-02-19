package com.bloste_software.domain.models.entities.location;

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
public class Location implements Serializable{
    @Serial
    private static final Long serialVersionUID=17L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_location")
    private Integer id;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column
    private String name;


    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_city", nullable = false)
    private City idCity;
    
}
