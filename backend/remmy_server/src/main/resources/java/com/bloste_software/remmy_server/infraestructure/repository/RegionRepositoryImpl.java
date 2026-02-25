package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.entities.location.Region;
import com.bloste_software.remmy_server.domain.repository.RegionRepository;
import com.bloste_software.remmy_server.infraestructure.repository.jpa.RegionJpaRepository;
import com.bloste_software.remmy_server.presentation.dtos.RegionDTO;

@Service
public class RegionRepositoryImpl implements RegionRepository {
    private final RegionJpaRepository jpaRepository;
    public RegionRepositoryImpl(RegionJpaRepository jpaRepository) { this.jpaRepository = jpaRepository; }
    @Override public List<RegionDTO> getAll() { return jpaRepository.findAll().stream().map(RegionDTO::convertToDTO).collect(Collectors.toList()); }
    @Override public void save(RegionDTO dto) { jpaRepository.save(dto.toEntity()); }
    @Override public void saveEntity(Region entity) { jpaRepository.save(entity); }
    @Override public boolean existsById(Long id) { return jpaRepository.existsById(id); }
    @Override public RegionDTO getById(Long id) { return jpaRepository.findById(id).map(RegionDTO::convertToDTO).orElse(null); }
    @Override public void deleteById(Long id) { jpaRepository.deleteById(id); }
    @Override public void updateById(Long id, RegionDTO dto) {
        Region entity = jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Region not found"));
        if (dto.getName() != null) entity.setName(dto.getName());
        jpaRepository.save(entity);
    }
    @Override public Optional<Region> findById(Long id) { return jpaRepository.findById(id); }
}
