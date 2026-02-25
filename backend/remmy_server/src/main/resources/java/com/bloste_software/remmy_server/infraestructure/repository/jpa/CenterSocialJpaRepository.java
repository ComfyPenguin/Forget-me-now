package com.bloste_software.remmy_server.infraestructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bloste_software.remmy_server.domain.models.entities.center.CenterSocial;
import com.bloste_software.remmy_server.domain.models.relationships.CenterSocialId;

public interface CenterSocialJpaRepository extends JpaRepository<CenterSocial, CenterSocialId> {
}
