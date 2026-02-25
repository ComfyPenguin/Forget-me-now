package com.bloste_software.remmy_server.infraestructure.controlers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bloste_software.remmy_server.application.usecases.region.*;
import com.bloste_software.remmy_server.presentation.dtos.RegionDTO;

@RestController
@RequestMapping("/region")
public class RegionController {
    private final getAllRegionsUseCase getAll;
    private final postRegionUseCase post;
    private final getRegionByIdUseCase getById;
    private final deleteRegionByIdUseCase deleteById;
    private final updateRegionByIdUseCase updateById;

    public RegionController(getAllRegionsUseCase getAll, postRegionUseCase post, getRegionByIdUseCase getById, deleteRegionByIdUseCase deleteById, updateRegionByIdUseCase updateById) {
        this.getAll = getAll; this.post = post; this.getById = getById; this.deleteById = deleteById; this.updateById = updateById;
    }

    @CrossOrigin(origins = "*") @GetMapping
    public ResponseEntity<List<RegionDTO>> getAll() { return ResponseEntity.ok(getAll.execute()); }

    @CrossOrigin(origins = "*") @PostMapping
    public ResponseEntity<Void> create(@RequestBody RegionDTO dto) { post.execute(dto); return ResponseEntity.status(201).build(); }

    @CrossOrigin(origins = "*") @GetMapping("/id/{id}")
    public ResponseEntity<RegionDTO> getById(@PathVariable Long id) {
        RegionDTO dto = getById.execute(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*") @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try { deleteById.execute(id); return ResponseEntity.noContent().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }

    @CrossOrigin(origins = "*") @PatchMapping("/id/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody RegionDTO dto) {
        try { updateById.execute(id, dto); return ResponseEntity.ok().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }
}
