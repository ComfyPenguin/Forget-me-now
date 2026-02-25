package com.bloste_software.remmy_server.application.usecases.social;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.SocialRepository;

@Service
public class deleteSocialByIdUseCase {
    private final SocialRepository repository;
    public deleteSocialByIdUseCase(SocialRepository repository) { this.repository = repository; }
    public void execute(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new RuntimeException("Social not found");
    }
}
