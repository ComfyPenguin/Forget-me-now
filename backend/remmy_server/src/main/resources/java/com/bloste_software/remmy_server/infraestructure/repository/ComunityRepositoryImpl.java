package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.entities.location.Comunity;
import com.bloste_software.remmy_server.domain.models.entities.location.Region;
import com.bloste_software.remmy_server.domain.repository.ComunityRepository;
import com.bloste_software.remmy_server.infraestructure.repository.jpa.ComunityJpaRepository;
import com.bloste_software.remmy_server.presentation.dtos.ComunityDTO;

@Service
public class ComunityRepositoryImpl implements ComunityRepository {
    private final ComunityJpaRepository jpaRepository;
    public ComunityRepositoryImpl(ComunityJpaRepository jpaRepository) { this.jpaRepository = jpaRepository; }
    @Override public List<ComunityDTO> getAll() { return jpaRepository.findAll().stream().map(ComunityDTO::convertToDTO).collect(Collectors.toList()); }
    @Override public void save(ComunityDTO dto) { jpaRepository.save(dto.toEntity()); }
    @Override public void saveEntity(Comunity entity) { jpaRepository.save(entity); }
    @Override public boolean existsById(Long id) { return jpaRepository.existsById(id); }
    @Override public ComunityDTO getById(Long id) { return jpaRepository.findById(id).map(ComunityDTO::convertToDTO).orElse(null); }
    @Override public void deleteById(Long id) { jpaRepository.deleteById(id); }
    @Override public void updateById(Long id, ComunityDTO dto) {
        Comunity entity = jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Comunity not found"));
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getRegionId() != null) {
            Region region = new Region(); region.setId(dto.getRegionId()); entity.setRegion(region);
        }
        jpaRepository.save(entity);
    }
    @Override public Optional<Comunity> findById(Long id) { return jpaRepository.findById(id); }
}
