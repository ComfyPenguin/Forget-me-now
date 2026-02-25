package com.bloste_software.remmy_server.application.usecases.centercharacteristic;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterCharacteristicRepository;

@Service
public class deleteCenterCharacteristicByIdUseCase {
    private final CenterCharacteristicRepository repository;
    public deleteCenterCharacteristicByIdUseCase(CenterCharacteristicRepository repository) { this.repository = repository; }
    public void execute(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new RuntimeException("CenterCharacteristic not found");
    }
}
