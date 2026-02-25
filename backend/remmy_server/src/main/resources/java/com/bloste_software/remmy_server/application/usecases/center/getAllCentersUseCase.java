package com.bloste_software.remmy_server.application.usecases.center;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterDTO;

@Service
public class getAllCentersUseCase {
    private final CenterRepository centerRepository;

    public getAllCentersUseCase(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    public List<CenterDTO> execute() {
        return centerRepository.getAllCenters();
    }
}
