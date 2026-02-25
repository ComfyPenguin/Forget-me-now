package com.bloste_software.remmy_server.application.usecases.centercharacteristic;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterCharacteristicRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterCharacteristicDTO;

@Service
public class updateCenterCharacteristicByIdUseCase {
    private final CenterCharacteristicRepository repository;
    public updateCenterCharacteristicByIdUseCase(CenterCharacteristicRepository repository) { this.repository = repository; }
    public void execute(Long id, CenterCharacteristicDTO dto) {
        if (repository.existsById(id)) repository.updateById(id, dto);
        else throw new RuntimeException("CenterCharacteristic not found");
    }
}
