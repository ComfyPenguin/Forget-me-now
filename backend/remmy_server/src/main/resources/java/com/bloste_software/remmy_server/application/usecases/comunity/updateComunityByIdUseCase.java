package com.bloste_software.remmy_server.application.usecases.comunity;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.ComunityRepository;
import com.bloste_software.remmy_server.presentation.dtos.ComunityDTO;

@Service
public class updateComunityByIdUseCase {
    private final ComunityRepository repository;
    public updateComunityByIdUseCase(ComunityRepository repository) { this.repository = repository; }
    public void execute(Long id, ComunityDTO dto) {
        if (repository.existsById(id)) repository.updateById(id, dto);
        else throw new RuntimeException("Comunity not found");
    }
}
