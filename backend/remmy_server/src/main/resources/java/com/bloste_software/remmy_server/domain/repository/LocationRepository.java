package com.bloste_software.remmy_server.domain.repository;

import java.util.List;
import java.util.Optional;
import com.bloste_software.remmy_server.domain.models.entities.location.Location;
import com.bloste_software.remmy_server.presentation.dtos.LocationDTO;

public interface LocationRepository {
    List<LocationDTO> getAll();
    void save(LocationDTO dto);
    void saveEntity(Location entity);
    boolean existsById(Integer id);
    LocationDTO getById(Integer id);
    void deleteById(Integer id);
    void updateById(Integer id, LocationDTO dto);
    Optional<Location> findById(Integer id);
}
