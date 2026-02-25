package com.bloste_software.remmy_server.application.usecases.centersocial;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.relationships.CenterSocialId;
import com.bloste_software.remmy_server.domain.repository.CenterSocialRepository;

@Service
public class deleteCenterSocialByIdUseCase {
    private final CenterSocialRepository repository;
    public deleteCenterSocialByIdUseCase(CenterSocialRepository repository) { this.repository = repository; }
    public void execute(Long centerId, Long socialId) {
        CenterSocialId id = new CenterSocialId();
        id.setCenterId(centerId);
        id.setSocialId(socialId);
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new RuntimeException("CenterSocial not found");
    }
}
