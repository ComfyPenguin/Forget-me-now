package com.bloste_software.remmy_server.domain.repository;

import java.util.List;
import java.util.Optional;

import com.bloste_software.remmy_server.domain.models.entities.center.Center;
import com.bloste_software.remmy_server.presentation.dtos.CenterDTO;

public interface CenterRepository {

    List<CenterDTO> getAllCenters();

    void save(CenterDTO center);

    void saveEntity(Center center);

    boolean existsById(Long id);

    CenterDTO getById(Long id);

    void deleteById(Long id);

    void updateById(Long id, CenterDTO dto);

    Optional<Center> findById(Long id);
}