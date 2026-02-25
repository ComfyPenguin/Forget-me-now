package com.bloste_software.remmy_server.application.usecases.comunity;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.ComunityRepository;
import com.bloste_software.remmy_server.presentation.dtos.ComunityDTO;

@Service
public class postComunityUseCase {
    private final ComunityRepository repository;
    public postComunityUseCase(ComunityRepository repository) { this.repository = repository; }
    public void execute(ComunityDTO dto) { repository.save(dto); }
}
