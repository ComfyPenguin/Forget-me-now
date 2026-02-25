package com.bloste_software.remmy_server.application.usecases.region;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.RegionRepository;

@Service
public class deleteRegionByIdUseCase {
    private final RegionRepository repository;
    public deleteRegionByIdUseCase(RegionRepository repository) { this.repository = repository; }
    public void execute(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new RuntimeException("Region not found");
    }
}
