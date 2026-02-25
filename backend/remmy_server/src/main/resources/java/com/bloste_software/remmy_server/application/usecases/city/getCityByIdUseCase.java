package com.bloste_software.remmy_server.application.usecases.city;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CityRepository;
import com.bloste_software.remmy_server.presentation.dtos.CityDTO;

@Service
public class getCityByIdUseCase {
    private final CityRepository repository;
    public getCityByIdUseCase(CityRepository repository) { this.repository = repository; }
    public CityDTO execute(Long id) { return repository.getById(id); }
}
