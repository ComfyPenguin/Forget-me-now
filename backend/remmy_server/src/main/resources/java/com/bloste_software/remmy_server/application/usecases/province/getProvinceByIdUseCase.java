package com.bloste_software.remmy_server.application.usecases.province;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.ProvinceRepository;
import com.bloste_software.remmy_server.presentation.dtos.ProvinceDTO;

@Service
public class getProvinceByIdUseCase {
    private final ProvinceRepository repository;
    public getProvinceByIdUseCase(ProvinceRepository repository) { this.repository = repository; }
    public ProvinceDTO execute(Long id) { return repository.getById(id); }
}
