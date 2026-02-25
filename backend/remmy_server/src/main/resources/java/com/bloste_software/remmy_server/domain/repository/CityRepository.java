package com.bloste_software.remmy_server.domain.repository;

import java.util.List;
import java.util.Optional;
import com.bloste_software.remmy_server.domain.models.entities.location.City;
import com.bloste_software.remmy_server.presentation.dtos.CityDTO;

public interface CityRepository {
    List<CityDTO> getAll();
    void save(CityDTO dto);
    void saveEntity(City entity);
    boolean existsById(Long id);
    CityDTO getById(Long id);
    void deleteById(Long id);
    void updateById(Long id, CityDTO dto);
    Optional<City> findById(Long id);
}
