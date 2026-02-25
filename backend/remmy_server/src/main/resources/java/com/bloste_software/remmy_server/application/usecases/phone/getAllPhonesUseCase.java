package com.bloste_software.remmy_server.application.usecases.phone;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.PhoneRepository;
import com.bloste_software.remmy_server.presentation.dtos.PhoneDTO;

@Service
public class getAllPhonesUseCase {
    private final PhoneRepository repository;
    public getAllPhonesUseCase(PhoneRepository repository) { this.repository = repository; }
    public List<PhoneDTO> execute() { return repository.getAll(); }
}
