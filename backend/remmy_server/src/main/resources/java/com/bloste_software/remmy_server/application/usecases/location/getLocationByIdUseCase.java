package com.bloste_software.remmy_server.application.usecases.location;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.LocationRepository;
import com.bloste_software.remmy_server.presentation.dtos.LocationDTO;

@Service
public class getLocationByIdUseCase {
    private final LocationRepository repository;
    public getLocationByIdUseCase(LocationRepository repository) { this.repository = repository; }
    public LocationDTO execute(Integer id) { return repository.getById(id); }
}
