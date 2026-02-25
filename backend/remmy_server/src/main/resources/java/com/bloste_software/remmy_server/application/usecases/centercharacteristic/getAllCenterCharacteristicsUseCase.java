package com.bloste_software.remmy_server.application.usecases.centercharacteristic;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterCharacteristicRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterCharacteristicDTO;

@Service
public class getAllCenterCharacteristicsUseCase {
    private final CenterCharacteristicRepository repository;
    public getAllCenterCharacteristicsUseCase(CenterCharacteristicRepository repository) { this.repository = repository; }
    public List<CenterCharacteristicDTO> execute() { return repository.getAll(); }
}
