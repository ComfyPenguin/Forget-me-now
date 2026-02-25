package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.entities.center.CenterType;
import com.bloste_software.remmy_server.domain.repository.CenterTypeRepository;
import com.bloste_software.remmy_server.infraestructure.repository.jpa.CenterTypeJpaRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterTypeDTO;

@Service
public class CenterTypeRepositoryImpl implements CenterTypeRepository {

    private final CenterTypeJpaRepository jpaRepository;

    public CenterTypeRepositoryImpl(CenterTypeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<CenterTypeDTO> getAll() {
        return jpaRepository.findAll().stream()
                .map(CenterTypeDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void save(CenterTypeDTO dto) {
        jpaRepository.save(dto.toEntity());
    }

    @Override
    public void saveEntity(CenterType entity) {
        jpaRepository.save(entity);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public CenterTypeDTO getById(Long id) {
        return jpaRepository.findById(id).map(CenterTypeDTO::convertToDTO).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, CenterTypeDTO dto) {
        CenterType entity = jpaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("CenterType not found"));
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        jpaRepository.save(entity);
    }

    @Override
    public Optional<CenterType> findById(Long id) {
        return jpaRepository.findById(id);
    }
}
