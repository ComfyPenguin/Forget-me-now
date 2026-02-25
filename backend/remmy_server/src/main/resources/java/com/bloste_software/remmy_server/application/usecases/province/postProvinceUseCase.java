package com.bloste_software.remmy_server.application.usecases.province;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.ProvinceRepository;
import com.bloste_software.remmy_server.presentation.dtos.ProvinceDTO;

@Service
public class postProvinceUseCase {
    private final ProvinceRepository repository;
    public postProvinceUseCase(ProvinceRepository repository) { this.repository = repository; }
    public void execute(ProvinceDTO dto) { repository.save(dto); }
}
