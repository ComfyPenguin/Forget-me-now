package com.bloste_software.remmy_server.application.usecases.centertype;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterTypeRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterTypeDTO;

@Service
public class updateCenterTypeByIdUseCase {
    private final CenterTypeRepository repository;

    public updateCenterTypeByIdUseCase(CenterTypeRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id, CenterTypeDTO dto) {
        if (repository.existsById(id)) {
            repository.updateById(id, dto);
        } else {
            throw new RuntimeException("CenterType not found");
        }
    }
}
