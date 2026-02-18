package com.bloste_software.infraestructure.repository.jpa;

import com.bloste_software.domain.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserJpaRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    Usuario findByEmail(String email);
}
