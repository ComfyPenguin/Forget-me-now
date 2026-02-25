package com.bloste_software.remmy_server.application.usecases.center;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterDTO;

@Service
public class getCenterByIdUseCase {
    private final CenterRepository centerRepository;

    public getCenterByIdUseCase(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    public CenterDTO execute(Long id) {
        return centerRepository.getById(id);
    }
}
