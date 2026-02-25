package com.bloste_software.remmy_server.application.usecases.comunity;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.ComunityRepository;
import com.bloste_software.remmy_server.presentation.dtos.ComunityDTO;

@Service
public class getAllComunitiesUseCase {
    private final ComunityRepository repository;
    public getAllComunitiesUseCase(ComunityRepository repository) { this.repository = repository; }
    public List<ComunityDTO> execute() { return repository.getAll(); }
}
