package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.entities.location.Province;
import com.bloste_software.remmy_server.domain.models.entities.location.Comunity;
import com.bloste_software.remmy_server.domain.repository.ProvinceRepository;
import com.bloste_software.remmy_server.infraestructure.repository.jpa.ProvinceJpaRepository;
import com.bloste_software.remmy_server.presentation.dtos.ProvinceDTO;

@Service
public class ProvinceRepositoryImpl implements ProvinceRepository {
    private final ProvinceJpaRepository jpaRepository;
    public ProvinceRepositoryImpl(ProvinceJpaRepository jpaRepository) { this.jpaRepository = jpaRepository; }
    @Override public List<ProvinceDTO> getAll() { return jpaRepository.findAll().stream().map(ProvinceDTO::convertToDTO).collect(Collectors.toList()); }
    @Override public void save(ProvinceDTO dto) { jpaRepository.save(dto.toEntity()); }
    @Override public void saveEntity(Province entity) { jpaRepository.save(entity); }
    @Override public boolean existsById(Long id) { return jpaRepository.existsById(id); }
    @Override public ProvinceDTO getById(Long id) { return jpaRepository.findById(id).map(ProvinceDTO::convertToDTO).orElse(null); }
    @Override public void deleteById(Long id) { jpaRepository.deleteById(id); }
    @Override public void updateById(Long id, ProvinceDTO dto) {
        Province entity = jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Province not found"));
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getComunityId() != null) {
            Comunity comunity = new Comunity(); comunity.setId(dto.getComunityId()); entity.setComunity(comunity);
        }
        jpaRepository.save(entity);
    }
    @Override public Optional<Province> findById(Long id) { return jpaRepository.findById(id); }
}
