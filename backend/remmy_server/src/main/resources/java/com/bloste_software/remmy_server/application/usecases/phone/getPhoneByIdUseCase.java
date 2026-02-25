package com.bloste_software.remmy_server.application.usecases.phone;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.PhoneRepository;
import com.bloste_software.remmy_server.presentation.dtos.PhoneDTO;

@Service
public class getPhoneByIdUseCase {
    private final PhoneRepository repository;
    public getPhoneByIdUseCase(PhoneRepository repository) { this.repository = repository; }
    public PhoneDTO execute(Long id) { return repository.getById(id); }
}
