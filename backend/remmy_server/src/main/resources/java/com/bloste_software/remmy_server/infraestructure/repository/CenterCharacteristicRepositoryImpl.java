package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.entities.center.CenterCharacteristic;
import com.bloste_software.remmy_server.domain.models.entities.center.Center;
import com.bloste_software.remmy_server.domain.repository.CenterCharacteristicRepository;
import com.bloste_software.remmy_server.infraestructure.repository.jpa.CenterCharacteristicJpaRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterCharacteristicDTO;

@Service
public class CenterCharacteristicRepositoryImpl implements CenterCharacteristicRepository {
    private final CenterCharacteristicJpaRepository jpaRepository;
    public CenterCharacteristicRepositoryImpl(CenterCharacteristicJpaRepository jpaRepository) { this.jpaRepository = jpaRepository; }
    @Override public List<CenterCharacteristicDTO> getAll() { return jpaRepository.findAll().stream().map(CenterCharacteristicDTO::convertToDTO).collect(Collectors.toList()); }
    @Override public void save(CenterCharacteristicDTO dto) { jpaRepository.save(dto.toEntity()); }
    @Override public void saveEntity(CenterCharacteristic entity) { jpaRepository.save(entity); }
    @Override public boolean existsById(Long id) { return jpaRepository.existsById(id); }
    @Override public CenterCharacteristicDTO getById(Long id) { return jpaRepository.findById(id).map(CenterCharacteristicDTO::convertToDTO).orElse(null); }
    @Override public void deleteById(Long id) { jpaRepository.deleteById(id); }
    @Override public void updateById(Long id, CenterCharacteristicDTO dto) {
        CenterCharacteristic entity = jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("CenterCharacteristic not found"));
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getCenterId() != null) {
            Center center = new Center(); center.setId(dto.getCenterId()); entity.setCenter(center);
        }
        jpaRepository.save(entity);
    }
    @Override public Optional<CenterCharacteristic> findById(Long id) { return jpaRepository.findById(id); }
}
