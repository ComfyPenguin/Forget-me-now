package com.bloste_software.remmy_server.infraestructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bloste_software.remmy_server.domain.models.entities.users.Users;

import jakarta.transaction.Transactional;

@Repository
public interface UserJpaRepository extends JpaRepository<Users, Long> {

    boolean existsByEmail(String email);

    Users findByEmail(String email);

    @Modifying
    @Transactional
    @Query("DELETE FROM Users u WHERE u.email = :email")
    void deleteByEmail(@Param("email") String email);

    // Patch parcial segur
    @Modifying
    @Transactional
    @Query("UPDATE Users u SET "
         + "u.username = COALESCE(:username, u.username), "
         + "u.passwordHashed = COALESCE(:password, u.passwordHashed), "
         + "u.updatedAt = CURRENT_TIMESTAMP "
         + "WHERE u.email = :email")
    int updateByEmail(@Param("email") String email,
                      @Param("username") String username,
                      @Param("password") String password);
}