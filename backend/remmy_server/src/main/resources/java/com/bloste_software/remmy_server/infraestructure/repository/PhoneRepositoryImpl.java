package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.entities.contact.Phone;
import com.bloste_software.remmy_server.domain.models.entities.center.Center;
import com.bloste_software.remmy_server.domain.repository.PhoneRepository;
import com.bloste_software.remmy_server.infraestructure.repository.jpa.PhoneJpaRepository;
import com.bloste_software.remmy_server.presentation.dtos.PhoneDTO;

@Service
public class PhoneRepositoryImpl implements PhoneRepository {
    private final PhoneJpaRepository jpaRepository;
    public PhoneRepositoryImpl(PhoneJpaRepository jpaRepository) { this.jpaRepository = jpaRepository; }
    @Override public List<PhoneDTO> getAll() { return jpaRepository.findAll().stream().map(PhoneDTO::convertToDTO).collect(Collectors.toList()); }
    @Override public void save(PhoneDTO dto) { jpaRepository.save(dto.toEntity()); }
    @Override public void saveEntity(Phone entity) { jpaRepository.save(entity); }
    @Override public boolean existsById(Long id) { return jpaRepository.existsById(id); }
    @Override public PhoneDTO getById(Long id) { return jpaRepository.findById(id).map(PhoneDTO::convertToDTO).orElse(null); }
    @Override public void deleteById(Long id) { jpaRepository.deleteById(id); }
    @Override public void updateById(Long id, PhoneDTO dto) {
        Phone entity = jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Phone not found"));
        if (dto.getPhone() != null) entity.setPhone(dto.getPhone());
        if (dto.getCenterId() != null) {
            Center center = new Center(); center.setId(dto.getCenterId()); entity.setCenter(center);
        }
        jpaRepository.save(entity);
    }
    @Override public Optional<Phone> findById(Long id) { return jpaRepository.findById(id); }
}
