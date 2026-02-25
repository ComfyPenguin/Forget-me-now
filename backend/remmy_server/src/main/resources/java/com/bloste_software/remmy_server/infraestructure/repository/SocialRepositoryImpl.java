package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.entities.contact.Social;
import com.bloste_software.remmy_server.domain.repository.SocialRepository;
import com.bloste_software.remmy_server.infraestructure.repository.jpa.SocialJpaRepository;
import com.bloste_software.remmy_server.presentation.dtos.SocialDTO;

@Service
public class SocialRepositoryImpl implements SocialRepository {
    private final SocialJpaRepository jpaRepository;
    public SocialRepositoryImpl(SocialJpaRepository jpaRepository) { this.jpaRepository = jpaRepository; }
    @Override public List<SocialDTO> getAll() { return jpaRepository.findAll().stream().map(SocialDTO::convertToDTO).collect(Collectors.toList()); }
    @Override public void save(SocialDTO dto) { jpaRepository.save(dto.toEntity()); }
    @Override public void saveEntity(Social entity) { jpaRepository.save(entity); }
    @Override public boolean existsById(Long id) { return jpaRepository.existsById(id); }
    @Override public SocialDTO getById(Long id) { return jpaRepository.findById(id).map(SocialDTO::convertToDTO).orElse(null); }
    @Override public void deleteById(Long id) { jpaRepository.deleteById(id); }
    @Override public void updateById(Long id, SocialDTO dto) {
        Social entity = jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Social not found"));
        if (dto.getName() != null) entity.setName(dto.getName());
        jpaRepository.save(entity);
    }
    @Override public Optional<Social> findById(Long id) { return jpaRepository.findById(id); }
}
