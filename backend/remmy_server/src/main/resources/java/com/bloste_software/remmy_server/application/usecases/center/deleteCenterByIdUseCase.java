package com.bloste_software.remmy_server.application.usecases.center;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterRepository;

@Service
public class deleteCenterByIdUseCase {
    private final CenterRepository centerRepository;

    public deleteCenterByIdUseCase(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    public void execute(Long id) {
        if (centerRepository.existsById(id)) {
            centerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Center not found");
        }
    }
}
