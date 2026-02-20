package com.bloste_software.remmy_server.infraestructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloste_software.remmy_server.domain.models.entities.users.Users;

@Repository
public interface UserJpaRepository extends JpaRepository<Users, Long> {

    boolean existsByEmail(String email);

    Users findByEmail(String email);

    Users deleteByEmail(String email);

    // Users editByEmail(String email);
}
