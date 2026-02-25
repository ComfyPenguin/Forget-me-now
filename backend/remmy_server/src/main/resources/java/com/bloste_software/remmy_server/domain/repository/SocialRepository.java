package com.bloste_software.remmy_server.domain.repository;

import java.util.List;
import java.util.Optional;
import com.bloste_software.remmy_server.domain.models.entities.contact.Social;
import com.bloste_software.remmy_server.presentation.dtos.SocialDTO;

public interface SocialRepository {
    List<SocialDTO> getAll();
    void save(SocialDTO dto);
    void saveEntity(Social entity);
    boolean existsById(Long id);
    SocialDTO getById(Long id);
    void deleteById(Long id);
    void updateById(Long id, SocialDTO dto);
    Optional<Social> findById(Long id);
}
