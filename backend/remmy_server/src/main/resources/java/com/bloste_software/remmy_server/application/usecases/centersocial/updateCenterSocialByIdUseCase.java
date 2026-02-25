package com.bloste_software.remmy_server.application.usecases.centersocial;

import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.relationships.CenterSocialId;
import com.bloste_software.remmy_server.domain.repository.CenterSocialRepository;
import com.bloste_software.remmy_server.presentation.dtos.CenterSocialDTO;

@Service
public class updateCenterSocialByIdUseCase {
    private final CenterSocialRepository repository;
    public updateCenterSocialByIdUseCase(CenterSocialRepository repository) { this.repository = repository; }
    public void execute(Long centerId, Long socialId, CenterSocialDTO dto) {
        CenterSocialId id = new CenterSocialId();
        id.setCenterId(centerId);
        id.setSocialId(socialId);
        if (repository.existsById(id)) repository.updateById(id, dto);
        else throw new RuntimeException("CenterSocial not found");
    }
}
