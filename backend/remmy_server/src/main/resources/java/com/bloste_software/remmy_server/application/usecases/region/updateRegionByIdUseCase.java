package com.bloste_software.remmy_server.application.usecases.region;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.RegionRepository;
import com.bloste_software.remmy_server.presentation.dtos.RegionDTO;

@Service
public class updateRegionByIdUseCase {
    private final RegionRepository repository;
    public updateRegionByIdUseCase(RegionRepository repository) { this.repository = repository; }
    public void execute(Long id, RegionDTO dto) {
        if (repository.existsById(id)) repository.updateById(id, dto);
        else throw new RuntimeException("Region not found");
    }
}
