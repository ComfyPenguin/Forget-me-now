package com.bloste_software.remmy_server.application.usecases.province;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.ProvinceRepository;
import com.bloste_software.remmy_server.presentation.dtos.ProvinceDTO;

@Service
public class getAllProvincesUseCase {
    private final ProvinceRepository repository;
    public getAllProvincesUseCase(ProvinceRepository repository) { this.repository = repository; }
    public List<ProvinceDTO> execute() { return repository.getAll(); }
}
