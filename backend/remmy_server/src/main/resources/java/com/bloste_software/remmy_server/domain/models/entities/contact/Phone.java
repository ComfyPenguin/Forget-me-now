package com.bloste_software.remmy_server.domain.models.entities.contact;

import java.io.Serial;
import java.io.Serializable;

import com.bloste_software.remmy_server.domain.models.entities.center.Center;

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
public class Phone implements Serializable {
    @Serial
    private static final Long serialVersionUID=17L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String phone;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_center", nullable = false)
    private Center center;
}
