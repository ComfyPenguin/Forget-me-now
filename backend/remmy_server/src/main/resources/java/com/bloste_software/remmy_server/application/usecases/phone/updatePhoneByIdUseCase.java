package com.bloste_software.remmy_server.application.usecases.phone;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.PhoneRepository;
import com.bloste_software.remmy_server.presentation.dtos.PhoneDTO;

@Service
public class updatePhoneByIdUseCase {
    private final PhoneRepository repository;
    public updatePhoneByIdUseCase(PhoneRepository repository) { this.repository = repository; }
    public void execute(Long id, PhoneDTO dto) {
        if (repository.existsById(id)) repository.updateById(id, dto);
        else throw new RuntimeException("Phone not found");
    }
}
