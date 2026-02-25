package com.bloste_software.remmy_server.infraestructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bloste_software.remmy_server.domain.models.entities.center.CenterType;

public interface CenterTypeJpaRepository extends JpaRepository<CenterType, Long> {
}
