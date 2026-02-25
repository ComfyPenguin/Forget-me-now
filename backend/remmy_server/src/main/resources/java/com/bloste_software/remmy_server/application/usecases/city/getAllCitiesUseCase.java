package com.bloste_software.remmy_server.application.usecases.city;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CityRepository;
import com.bloste_software.remmy_server.presentation.dtos.CityDTO;

@Service
public class getAllCitiesUseCase {
    private final CityRepository repository;
    public getAllCitiesUseCase(CityRepository repository) { this.repository = repository; }
    public List<CityDTO> execute() { return repository.getAll(); }
}
