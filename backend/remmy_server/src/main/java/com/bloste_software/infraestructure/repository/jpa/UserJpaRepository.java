package com.bloste_software.infraestructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloste_software.domain.models.entities.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    User findByEmail(String email);

    User deleteByEmail(String email);

    User editByEmail(String email);
}
