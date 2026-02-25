package com.bloste_software.remmy_server.application.usecases.location;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.LocationRepository;
import com.bloste_software.remmy_server.presentation.dtos.LocationDTO;

@Service
public class postLocationUseCase {
    private final LocationRepository repository;
    public postLocationUseCase(LocationRepository repository) { this.repository = repository; }
    public void execute(LocationDTO dto) { repository.save(dto); }
}
