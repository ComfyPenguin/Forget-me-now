package com.bloste_software.remmy_server.application.usecases.region;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.RegionRepository;
import com.bloste_software.remmy_server.presentation.dtos.RegionDTO;

@Service
public class getRegionByIdUseCase {
    private final RegionRepository repository;
    public getRegionByIdUseCase(RegionRepository repository) { this.repository = repository; }
    public RegionDTO execute(Long id) { return repository.getById(id); }
}
