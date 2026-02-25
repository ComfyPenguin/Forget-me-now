package com.bloste_software.remmy_server.application.usecases.centertype;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterTypeRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterTypeDTO;

@Service
public class getAllCenterTypesUseCase {
    private final CenterTypeRepository repository;

    public getAllCenterTypesUseCase(CenterTypeRepository repository) {
        this.repository = repository;
    }

    public List<CenterTypeDTO> execute() {
        return repository.getAll();
    }
}
