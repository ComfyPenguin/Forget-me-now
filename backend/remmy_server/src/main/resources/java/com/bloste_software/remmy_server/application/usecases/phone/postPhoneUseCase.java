package com.bloste_software.remmy_server.application.usecases.phone;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.PhoneRepository;
import com.bloste_software.remmy_server.presentation.dtos.PhoneDTO;

@Service
public class postPhoneUseCase {
    private final PhoneRepository repository;
    public postPhoneUseCase(PhoneRepository repository) { this.repository = repository; }
    public void execute(PhoneDTO dto) { repository.save(dto); }
}
