package com.bloste_software.remmy_server.infraestructure.controlers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bloste_software.remmy_server.application.usecases.comunity.*;
import com.bloste_software.remmy_server.presentation.dtos.ComunityDTO;

@RestController
@RequestMapping("/comunity")
public class ComunityController {
    private final getAllComunitiesUseCase getAll;
    private final postComunityUseCase post;
    private final getComunityByIdUseCase getById;
    private final deleteComunityByIdUseCase deleteById;
    private final updateComunityByIdUseCase updateById;

    public ComunityController(getAllComunitiesUseCase getAll, postComunityUseCase post, getComunityByIdUseCase getById, deleteComunityByIdUseCase deleteById, updateComunityByIdUseCase updateById) {
        this.getAll = getAll; this.post = post; this.getById = getById; this.deleteById = deleteById; this.updateById = updateById;
    }

    @CrossOrigin(origins = "*") @GetMapping
    public ResponseEntity<List<ComunityDTO>> getAll() { return ResponseEntity.ok(getAll.execute()); }

    @CrossOrigin(origins = "*") @PostMapping
    public ResponseEntity<Void> create(@RequestBody ComunityDTO dto) { post.execute(dto); return ResponseEntity.status(201).build(); }

    @CrossOrigin(origins = "*") @GetMapping("/id/{id}")
    public ResponseEntity<ComunityDTO> getById(@PathVariable Long id) {
        ComunityDTO dto = getById.execute(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*") @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try { deleteById.execute(id); return ResponseEntity.noContent().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }

    @CrossOrigin(origins = "*") @PatchMapping("/id/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody ComunityDTO dto) {
        try { updateById.execute(id, dto); return ResponseEntity.ok().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }
}
