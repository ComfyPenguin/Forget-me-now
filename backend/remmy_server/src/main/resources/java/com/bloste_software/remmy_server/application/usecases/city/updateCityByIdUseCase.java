package com.bloste_software.remmy_server.application.usecases.city;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CityRepository;
import com.bloste_software.remmy_server.presentation.dtos.CityDTO;

@Service
public class updateCityByIdUseCase {
    private final CityRepository repository;
    public updateCityByIdUseCase(CityRepository repository) { this.repository = repository; }
    public void execute(Long id, CityDTO dto) {
        if (repository.existsById(id)) repository.updateById(id, dto);
        else throw new RuntimeException("City not found");
    }
}
