package com.bloste_software.remmy_server.application.usecases.center;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterDTO;

@Service
public class updateCenterByIdUseCase {
    private final CenterRepository centerRepository;

    public updateCenterByIdUseCase(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    public void execute(Long id, CenterDTO center) {
        if (centerRepository.existsById(id)) {
            centerRepository.updateById(id, center);
        } else {
            throw new RuntimeException("Center not found");
        }
    }
}
