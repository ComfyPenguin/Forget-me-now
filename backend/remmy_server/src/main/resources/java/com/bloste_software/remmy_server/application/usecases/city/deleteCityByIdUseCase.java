package com.bloste_software.remmy_server.application.usecases.city;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CityRepository;

@Service
public class deleteCityByIdUseCase {
    private final CityRepository repository;
    public deleteCityByIdUseCase(CityRepository repository) { this.repository = repository; }
    public void execute(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new RuntimeException("City not found");
    }
}
