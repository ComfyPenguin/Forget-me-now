package com.bloste_software.remmy_server.application.usecases.social;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.SocialRepository;
import com.bloste_software.remmy_server.presentation.dtos.SocialDTO;

@Service
public class updateSocialByIdUseCase {
    private final SocialRepository repository;
    public updateSocialByIdUseCase(SocialRepository repository) { this.repository = repository; }
    public void execute(Long id, SocialDTO dto) {
        if (repository.existsById(id)) repository.updateById(id, dto);
        else throw new RuntimeException("Social not found");
    }
}
