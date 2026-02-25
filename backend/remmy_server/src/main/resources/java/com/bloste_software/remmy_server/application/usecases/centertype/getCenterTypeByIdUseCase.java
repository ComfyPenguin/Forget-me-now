package com.bloste_software.remmy_server.application.usecases.centertype;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterTypeRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterTypeDTO;

@Service
public class getCenterTypeByIdUseCase {
    private final CenterTypeRepository repository;

    public getCenterTypeByIdUseCase(CenterTypeRepository repository) {
        this.repository = repository;
    }

    public CenterTypeDTO execute(Long id) {
        return repository.getById(id);
    }
}
