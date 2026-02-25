package com.bloste_software.remmy_server.application.usecases.comunity;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.ComunityRepository;

@Service
public class deleteComunityByIdUseCase {
    private final ComunityRepository repository;
    public deleteComunityByIdUseCase(ComunityRepository repository) { this.repository = repository; }
    public void execute(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new RuntimeException("Comunity not found");
    }
}
