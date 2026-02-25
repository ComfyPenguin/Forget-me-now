package com.bloste_software.remmy_server.domain.repository;

import java.util.List;
import java.util.Optional;
import com.bloste_software.remmy_server.domain.models.entities.center.CenterSocial;
import com.bloste_software.remmy_server.domain.models.relationships.CenterSocialId;
import com.bloste_software.remmy_server.presentation.dtos.CenterSocialDTO;

public interface CenterSocialRepository {
    List<CenterSocialDTO> getAll();
    void save(CenterSocialDTO dto);
    void saveEntity(CenterSocial entity);
    boolean existsById(CenterSocialId id);
    CenterSocialDTO getById(CenterSocialId id);
    void deleteById(CenterSocialId id);
    void updateById(CenterSocialId id, CenterSocialDTO dto);
    Optional<CenterSocial> findById(CenterSocialId id);
}
