package com.bloste_software.remmy_server.application.usecases.region;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.RegionRepository;
import com.bloste_software.remmy_server.presentation.dtos.RegionDTO;

@Service
public class postRegionUseCase {
    private final RegionRepository repository;
    public postRegionUseCase(RegionRepository repository) { this.repository = repository; }
    public void execute(RegionDTO dto) { repository.save(dto); }
}
