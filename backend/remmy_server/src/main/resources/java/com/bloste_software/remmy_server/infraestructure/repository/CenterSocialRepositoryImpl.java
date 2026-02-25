package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.entities.center.CenterSocial;
import com.bloste_software.remmy_server.domain.models.relationships.CenterSocialId;
import com.bloste_software.remmy_server.domain.repository.CenterSocialRepository;
import com.bloste_software.remmy_server.infraestructure.repository.jpa.CenterSocialJpaRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterSocialDTO;

@Service
public class CenterSocialRepositoryImpl implements CenterSocialRepository {
    private final CenterSocialJpaRepository jpaRepository;
    public CenterSocialRepositoryImpl(CenterSocialJpaRepository jpaRepository) { this.jpaRepository = jpaRepository; }
    @Override public List<CenterSocialDTO> getAll() { return jpaRepository.findAll().stream().map(CenterSocialDTO::convertToDTO).collect(Collectors.toList()); }
    @Override public void save(CenterSocialDTO dto) { jpaRepository.save(dto.toEntity()); }
    @Override public void saveEntity(CenterSocial entity) { jpaRepository.save(entity); }
    @Override public boolean existsById(CenterSocialId id) { return jpaRepository.existsById(id); }
    @Override public CenterSocialDTO getById(CenterSocialId id) { return jpaRepository.findById(id).map(CenterSocialDTO::convertToDTO).orElse(null); }
    @Override public void deleteById(CenterSocialId id) { jpaRepository.deleteById(id); }
    @Override public void updateById(CenterSocialId id, CenterSocialDTO dto) {
        CenterSocial entity = jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("CenterSocial not found"));
        if (dto.getLink() != null) entity.setLink(dto.getLink());
        jpaRepository.save(entity);
    }
    @Override public Optional<CenterSocial> findById(CenterSocialId id) { return jpaRepository.findById(id); }
}
