package com.bloste_software.remmy_server.infraestructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloste_software.remmy_server.domain.models.entities.center.Center;
import java.util.List;


public interface CenterJpaRepository extends JpaRepository<Center, Long> {

    boolean existsById(Long id);

    //Center findById(Long id);
    
}