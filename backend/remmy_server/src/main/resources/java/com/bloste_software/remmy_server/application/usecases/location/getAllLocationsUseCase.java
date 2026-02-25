package com.bloste_software.remmy_server.application.usecases.location;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.LocationRepository;
import com.bloste_software.remmy_server.presentation.dtos.LocationDTO;

@Service
public class getAllLocationsUseCase {
    private final LocationRepository repository;
    public getAllLocationsUseCase(LocationRepository repository) { this.repository = repository; }
    public List<LocationDTO> execute() { return repository.getAll(); }
}
