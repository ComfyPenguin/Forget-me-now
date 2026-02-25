package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.entities.location.Location;
import com.bloste_software.remmy_server.domain.models.entities.location.City;
import com.bloste_software.remmy_server.domain.repository.LocationRepository;
import com.bloste_software.remmy_server.infraestructure.repository.jpa.LocationJpaRepository;
import com.bloste_software.remmy_server.presentation.dtos.LocationDTO;

@Service
public class LocationRepositoryImpl implements LocationRepository {
    private final LocationJpaRepository jpaRepository;
    public LocationRepositoryImpl(LocationJpaRepository jpaRepository) { this.jpaRepository = jpaRepository; }
    @Override public List<LocationDTO> getAll() { return jpaRepository.findAll().stream().map(LocationDTO::convertToDTO).collect(Collectors.toList()); }
    @Override public void save(LocationDTO dto) { jpaRepository.save(dto.toEntity()); }
    @Override public void saveEntity(Location entity) { jpaRepository.save(entity); }
    @Override public boolean existsById(Integer id) { return jpaRepository.existsById(id); }
    @Override public LocationDTO getById(Integer id) { return jpaRepository.findById(id).map(LocationDTO::convertToDTO).orElse(null); }
    @Override public void deleteById(Integer id) { jpaRepository.deleteById(id); }
    @Override public void updateById(Integer id, LocationDTO dto) {
        Location entity = jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Location not found"));
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getPostalCode() != null) entity.setPostalCode(dto.getPostalCode());
        if (dto.getCityId() != null) {
            City city = new City(); city.setId(dto.getCityId()); entity.setIdCity(city);
        }
        jpaRepository.save(entity);
    }
    @Override public Optional<Location> findById(Integer id) { return jpaRepository.findById(id); }
}
