package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bloste_software.remmy_server.domain.models.entities.center.Center;
import com.bloste_software.remmy_server.domain.models.entities.center.CenterType;
import com.bloste_software.remmy_server.domain.models.entities.location.Location;
import com.bloste_software.remmy_server.domain.repository.CenterRepository;
import com.bloste_software.remmy_server.infraestructure.repository.jpa.CenterJpaRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterDTO;

@Service
public class CenterRepositoryImpl implements CenterRepository {

    private final CenterJpaRepository jpaRepository;

    public CenterRepositoryImpl(CenterJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<CenterDTO> getAllCenters() {
        return jpaRepository.findAll()
                .stream()
                .map(CenterDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void save(CenterDTO centerDTO) {
        jpaRepository.save(centerDTO.toEntity());
    }

    @Override
    public void saveEntity(Center center) {
        jpaRepository.save(center);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public CenterDTO getById(Long id) {
        return jpaRepository.findById(id).map(CenterDTO::convertToDTO).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, CenterDTO dto) {
        Center entity = jpaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Center no encontrado"));

        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getAddress() != null) {
            entity.setAddress(dto.getAddress());
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }
        if (dto.getTypeId() != null) {
            CenterType type = new CenterType();
            type.setId(dto.getTypeId());
            entity.setType(type);
        }
        if (dto.getLocationId() != null) {
            Location location = new Location();
            location.setId(dto.getLocationId());
            entity.setLocation(location);
        }

        entity.setUpdatedAt(java.time.LocalDateTime.now());

        jpaRepository.save(entity);
    }

    @Override
    public Optional<Center> findById(Long id) {
        return jpaRepository.findById(id);
    }
}