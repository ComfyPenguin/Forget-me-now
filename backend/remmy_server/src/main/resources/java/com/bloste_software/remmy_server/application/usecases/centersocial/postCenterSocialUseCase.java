package com.bloste_software.remmy_server.application.usecases.centersocial;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterSocialRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterSocialDTO;

@Service
public class postCenterSocialUseCase {
    private final CenterSocialRepository repository;
    public postCenterSocialUseCase(CenterSocialRepository repository) { this.repository = repository; }
    public void execute(CenterSocialDTO dto) { repository.save(dto); }
}
