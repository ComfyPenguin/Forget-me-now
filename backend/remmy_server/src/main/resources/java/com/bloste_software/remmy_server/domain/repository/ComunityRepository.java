package com.bloste_software.remmy_server.domain.repository;

import java.util.List;
import java.util.Optional;
import com.bloste_software.remmy_server.domain.models.entities.location.Comunity;
import com.bloste_software.remmy_server.presentation.dtos.ComunityDTO;

public interface ComunityRepository {
    List<ComunityDTO> getAll();
    void save(ComunityDTO dto);
    void saveEntity(Comunity entity);
    boolean existsById(Long id);
    ComunityDTO getById(Long id);
    void deleteById(Long id);
    void updateById(Long id, ComunityDTO dto);
    Optional<Comunity> findById(Long id);
}
