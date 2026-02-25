package com.bloste_software.remmy_server.infraestructure.controlers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bloste_software.remmy_server.application.usecases.centersocial.*;
import com.bloste_software.remmy_server.presentation.dtos.CenterSocialDTO;

@RestController
@RequestMapping("/center_social")
public class CenterSocialController {
    private final getAllCenterSocialsUseCase getAll;
    private final postCenterSocialUseCase post;
    private final getCenterSocialByIdUseCase getById;
    private final deleteCenterSocialByIdUseCase deleteById;
    private final updateCenterSocialByIdUseCase updateById;

    public CenterSocialController(getAllCenterSocialsUseCase getAll, postCenterSocialUseCase post, getCenterSocialByIdUseCase getById, deleteCenterSocialByIdUseCase deleteById, updateCenterSocialByIdUseCase updateById) {
        this.getAll = getAll; this.post = post; this.getById = getById; this.deleteById = deleteById; this.updateById = updateById;
    }

    @CrossOrigin(origins = "*") @GetMapping
    public ResponseEntity<List<CenterSocialDTO>> getAll() { return ResponseEntity.ok(getAll.execute()); }

    @CrossOrigin(origins = "*") @PostMapping
    public ResponseEntity<Void> create(@RequestBody CenterSocialDTO dto) { post.execute(dto); return ResponseEntity.status(201).build(); }

    @CrossOrigin(origins = "*") @GetMapping("/center/{centerId}/social/{socialId}")
    public ResponseEntity<CenterSocialDTO> getById(@PathVariable Long centerId, @PathVariable Long socialId) {
        CenterSocialDTO dto = getById.execute(centerId, socialId);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*") @DeleteMapping("/center/{centerId}/social/{socialId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long centerId, @PathVariable Long socialId) {
        try { deleteById.execute(centerId, socialId); return ResponseEntity.noContent().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }

    @CrossOrigin(origins = "*") @PatchMapping("/center/{centerId}/social/{socialId}")
    public ResponseEntity<Void> updateById(@PathVariable Long centerId, @PathVariable Long socialId, @RequestBody CenterSocialDTO dto) {
        try { updateById.execute(centerId, socialId, dto); return ResponseEntity.ok().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }
}
