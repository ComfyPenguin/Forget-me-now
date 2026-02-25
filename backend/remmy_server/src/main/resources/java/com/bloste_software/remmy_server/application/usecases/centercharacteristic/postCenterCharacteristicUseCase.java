package com.bloste_software.remmy_server.application.usecases.centercharacteristic;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterCharacteristicRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterCharacteristicDTO;

@Service
public class postCenterCharacteristicUseCase {
    private final CenterCharacteristicRepository repository;
    public postCenterCharacteristicUseCase(CenterCharacteristicRepository repository) { this.repository = repository; }
    public void execute(CenterCharacteristicDTO dto) { repository.save(dto); }
}
