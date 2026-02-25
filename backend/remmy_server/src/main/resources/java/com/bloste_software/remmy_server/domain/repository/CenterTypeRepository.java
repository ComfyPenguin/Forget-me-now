package com.bloste_software.remmy_server.domain.repository;

import java.util.List;
import java.util.Optional;
import com.bloste_software.remmy_server.domain.models.entities.center.CenterType;
import com.bloste_software.remmy_server.presentation.dtos.CenterTypeDTO;

public interface CenterTypeRepository {
    List<CenterTypeDTO> getAll();
    void save(CenterTypeDTO dto);
    void saveEntity(CenterType entity);
    boolean existsById(Long id);
    CenterTypeDTO getById(Long id);
    void deleteById(Long id);
    void updateById(Long id, CenterTypeDTO dto);
    Optional<CenterType> findById(Long id);
}
