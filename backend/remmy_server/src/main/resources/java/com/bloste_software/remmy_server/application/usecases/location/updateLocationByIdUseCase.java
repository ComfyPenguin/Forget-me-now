package com.bloste_software.remmy_server.application.usecases.location;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.LocationRepository;
import com.bloste_software.remmy_server.presentation.dtos.LocationDTO;

@Service
public class updateLocationByIdUseCase {
    private final LocationRepository repository;
    public updateLocationByIdUseCase(LocationRepository repository) { this.repository = repository; }
    public void execute(Integer id, LocationDTO dto) {
        if (repository.existsById(id)) repository.updateById(id, dto);
        else throw new RuntimeException("Location not found");
    }
}
