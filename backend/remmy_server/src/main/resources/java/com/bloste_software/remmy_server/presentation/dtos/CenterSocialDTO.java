package com.bloste_software.remmy_server.presentation.dtos;

import com.bloste_software.remmy_server.domain.models.entities.center.CenterSocial;
import com.bloste_software.remmy_server.domain.models.entities.center.Center;
import com.bloste_software.remmy_server.domain.models.entities.contact.Social;
import com.bloste_software.remmy_server.domain.models.relationships.CenterSocialId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CenterSocialDTO {
    private Long centerId;
    private Long socialId;
    private String link;

    public CenterSocialDTO(Long centerId, Long socialId, String link) {
        this.centerId = centerId;
        this.socialId = socialId;
        this.link = link;
    }

    public static CenterSocialDTO convertToDTO(CenterSocial entity) {
        if (entity == null) return null;
        return new CenterSocialDTO(entity.getId().getCenterId(), entity.getId().getSocialId(), entity.getLink());
    }

    public CenterSocial toEntity() {
        CenterSocial entity = new CenterSocial();
        CenterSocialId id = new CenterSocialId();
        id.setCenterId(this.centerId);
        id.setSocialId(this.socialId);
        entity.setId(id);
        entity.setLink(this.link);
        
        Center center = new Center();
        center.setId(this.centerId);
        entity.setCenter(center);
        
        Social social = new Social();
        social.setId(this.socialId);
        entity.setSocial(social);
        
        return entity;
    }
}
