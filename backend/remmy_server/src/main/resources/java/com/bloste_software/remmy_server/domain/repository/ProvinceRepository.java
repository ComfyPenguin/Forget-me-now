package com.bloste_software.remmy_server.domain.repository;

import java.util.List;
import java.util.Optional;
import com.bloste_software.remmy_server.domain.models.entities.location.Province;
import com.bloste_software.remmy_server.presentation.dtos.ProvinceDTO;

public interface ProvinceRepository {
    List<ProvinceDTO> getAll();
    void save(ProvinceDTO dto);
    void saveEntity(Province entity);
    boolean existsById(Long id);
    ProvinceDTO getById(Long id);
    void deleteById(Long id);
    void updateById(Long id, ProvinceDTO dto);
    Optional<Province> findById(Long id);
}
