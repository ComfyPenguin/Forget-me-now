package com.bloste_software.remmy_server.application.usecases.centersocial;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.relationships.CenterSocialId;
import com.bloste_software.remmy_server.domain.repository.CenterSocialRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterSocialDTO;

@Service
public class getCenterSocialByIdUseCase {
    private final CenterSocialRepository repository;
    public getCenterSocialByIdUseCase(CenterSocialRepository repository) { this.repository = repository; }
    public CenterSocialDTO execute(Long centerId, Long socialId) {
        CenterSocialId id = new CenterSocialId();
        id.setCenterId(centerId);
        id.setSocialId(socialId);
        return repository.getById(id);
    }
}
