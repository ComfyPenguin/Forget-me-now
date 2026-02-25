package com.bloste_software.remmy_server.application.usecases.social;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.SocialRepository;
import com.bloste_software.remmy_server.presentation.dtos.SocialDTO;

@Service
public class postSocialUseCase {
    private final SocialRepository repository;
    public postSocialUseCase(SocialRepository repository) { this.repository = repository; }
    public void execute(SocialDTO dto) { repository.save(dto); }
}
