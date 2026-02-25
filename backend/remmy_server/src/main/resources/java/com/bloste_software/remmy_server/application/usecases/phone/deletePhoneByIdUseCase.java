package com.bloste_software.remmy_server.application.usecases.phone;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.PhoneRepository;

@Service
public class deletePhoneByIdUseCase {
    private final PhoneRepository repository;
    public deletePhoneByIdUseCase(PhoneRepository repository) { this.repository = repository; }
    public void execute(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new RuntimeException("Phone not found");
    }
}
