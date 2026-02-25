package com.bloste_software.remmy_server.application.usecases.centersocial;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.repository.CenterSocialRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterSocialDTO;

@Service
public class getAllCenterSocialsUseCase {
    private final CenterSocialRepository repository;
    public getAllCenterSocialsUseCase(CenterSocialRepository repository) { this.repository = repository; }
    public List<CenterSocialDTO> execute() { return repository.getAll(); }
}
