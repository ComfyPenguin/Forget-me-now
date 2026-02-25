package com.bloste_software.remmy_server.application.usecases.center;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterDTO;

@Service
public class postCenterUseCase {
    private final CenterRepository centerRepository;

    public postCenterUseCase(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    public void execute(CenterDTO center) {
        centerRepository.save(center);
    }
}
