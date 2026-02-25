package com.bloste_software.remmy_server.application.usecases.province;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.ProvinceRepository;
import com.bloste_software.remmy_server.presentation.dtos.ProvinceDTO;

@Service
public class updateProvinceByIdUseCase {
    private final ProvinceRepository repository;
    public updateProvinceByIdUseCase(ProvinceRepository repository) { this.repository = repository; }
    public void execute(Long id, ProvinceDTO dto) {
        if (repository.existsById(id)) repository.updateById(id, dto);
        else throw new RuntimeException("Province not found");
    }
}
