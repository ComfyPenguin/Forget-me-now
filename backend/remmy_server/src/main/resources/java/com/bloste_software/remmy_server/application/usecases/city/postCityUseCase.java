package com.bloste_software.remmy_server.application.usecases.city;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CityRepository;
import com.bloste_software.remmy_server.presentation.dtos.CityDTO;

@Service
public class postCityUseCase {
    private final CityRepository repository;
    public postCityUseCase(CityRepository repository) { this.repository = repository; }
    public void execute(CityDTO dto) { repository.save(dto); }
}
