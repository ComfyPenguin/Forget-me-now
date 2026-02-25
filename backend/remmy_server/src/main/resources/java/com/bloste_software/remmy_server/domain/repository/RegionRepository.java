package com.bloste_software.remmy_server.domain.repository;

import java.util.List;
import java.util.Optional;
import com.bloste_software.remmy_server.domain.models.entities.location.Region;
import com.bloste_software.remmy_server.presentation.dtos.RegionDTO;

public interface RegionRepository {
    List<RegionDTO> getAll();
    void save(RegionDTO dto);
    void saveEntity(Region entity);
    boolean existsById(Long id);
    RegionDTO getById(Long id);
    void deleteById(Long id);
    void updateById(Long id, RegionDTO dto);
    Optional<Region> findById(Long id);
}
