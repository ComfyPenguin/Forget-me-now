package com.bloste_software.remmy_server.application.usecases.region;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.RegionRepository;
import com.bloste_software.remmy_server.presentation.dtos.RegionDTO;

@Service
public class getAllRegionsUseCase {
    private final RegionRepository repository;
    public getAllRegionsUseCase(RegionRepository repository) { this.repository = repository; }
    public List<RegionDTO> execute() { return repository.getAll(); }
}
