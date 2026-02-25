package com.bloste_software.remmy_server.domain.repository;

import java.util.List;
import java.util.Optional;
import com.bloste_software.remmy_server.domain.models.entities.contact.Phone;
import com.bloste_software.remmy_server.presentation.dtos.PhoneDTO;

public interface PhoneRepository {
    List<PhoneDTO> getAll();
    void save(PhoneDTO dto);
    void saveEntity(Phone entity);
    boolean existsById(Long id);
    PhoneDTO getById(Long id);
    void deleteById(Long id);
    void updateById(Long id, PhoneDTO dto);
    Optional<Phone> findById(Long id);
}
