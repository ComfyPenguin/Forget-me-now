package com.bloste_software.remmy_server.application.usecases.centertype;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterTypeRepository;

@Service
public class deleteCenterTypeByIdUseCase {
    private final CenterTypeRepository repository;

    public deleteCenterTypeByIdUseCase(CenterTypeRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("CenterType not found");
        }
    }
}
