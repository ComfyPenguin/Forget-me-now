package com.bloste_software.remmy_server.application.usecases.location;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.LocationRepository;

@Service
public class deleteLocationByIdUseCase {
    private final LocationRepository repository;
    public deleteLocationByIdUseCase(LocationRepository repository) { this.repository = repository; }
    public void execute(Integer id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new RuntimeException("Location not found");
    }
}
