package com.bloste_software.remmy_server.application.usecases.centertype;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterTypeRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterTypeDTO;

@Service
public class postCenterTypeUseCase {
    private final CenterTypeRepository repository;

    public postCenterTypeUseCase(CenterTypeRepository repository) {
        this.repository = repository;
    }

    public void execute(CenterTypeDTO dto) {
        repository.save(dto);
    }
}
