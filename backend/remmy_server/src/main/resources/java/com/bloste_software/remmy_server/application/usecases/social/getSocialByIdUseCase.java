package com.bloste_software.remmy_server.application.usecases.social;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.SocialRepository;
import com.bloste_software.remmy_server.presentation.dtos.SocialDTO;

@Service
public class getSocialByIdUseCase {
    private final SocialRepository repository;
    public getSocialByIdUseCase(SocialRepository repository) { this.repository = repository; }
    public SocialDTO execute(Long id) { return repository.getById(id); }
}
