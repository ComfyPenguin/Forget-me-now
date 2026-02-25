package com.bloste_software.remmy_server.application.usecases.comunity;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.ComunityRepository;
import com.bloste_software.remmy_server.presentation.dtos.ComunityDTO;

@Service
public class getComunityByIdUseCase {
    private final ComunityRepository repository;
    public getComunityByIdUseCase(ComunityRepository repository) { this.repository = repository; }
    public ComunityDTO execute(Long id) { return repository.getById(id); }
}
