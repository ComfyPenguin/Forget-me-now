package com.bloste_software.remmy_server.domain.repository;

import java.util.List;
import java.util.Optional;
import com.bloste_software.remmy_server.domain.models.entities.center.CenterCharacteristic;
import com.bloste_software.remmy_server.presentation.dtos.CenterCharacteristicDTO;

public interface CenterCharacteristicRepository {
    List<CenterCharacteristicDTO> getAll();
    void save(CenterCharacteristicDTO dto);
    void saveEntity(CenterCharacteristic entity);
    boolean existsById(Long id);
    CenterCharacteristicDTO getById(Long id);
    void deleteById(Long id);
    void updateById(Long id, CenterCharacteristicDTO dto);
    Optional<CenterCharacteristic> findById(Long id);
}
