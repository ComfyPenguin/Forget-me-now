package com.bloste_software.remmy_server.application.usecases.centercharacteristic;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterCharacteristicRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterCharacteristicDTO;

@Service
public class getCenterCharacteristicByIdUseCase {
    private final CenterCharacteristicRepository repository;
    public getCenterCharacteristicByIdUseCase(CenterCharacteristicRepository repository) { this.repository = repository; }
    public CenterCharacteristicDTO execute(Long id) { return repository.getById(id); }
}
