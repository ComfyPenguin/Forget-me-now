package com.bloste_software.remmy_server.application.usecases.social;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.SocialRepository;
import com.bloste_software.remmy_server.presentation.dtos.SocialDTO;

@Service
public class getAllSocialsUseCase {
    private final SocialRepository repository;
    public getAllSocialsUseCase(SocialRepository repository) { this.repository = repository; }
    public List<SocialDTO> execute() { return repository.getAll(); }
}
