package com.bloste_software.remmy_server.infraestructure.controlers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bloste_software.remmy_server.application.usecases.centertype.*;
import com.bloste_software.remmy_server.presentation.dtos.CenterTypeDTO;

@RestController
@RequestMapping("/center_type")
public class CenterTypeController {

    private final getAllCenterTypesUseCase getAll;
    private final postCenterTypeUseCase post;
    private final getCenterTypeByIdUseCase getById;
    private final deleteCenterTypeByIdUseCase deleteById;
    private final updateCenterTypeByIdUseCase updateById;

    public CenterTypeController(
            getAllCenterTypesUseCase getAll,
            postCenterTypeUseCase post,
            getCenterTypeByIdUseCase getById,
            deleteCenterTypeByIdUseCase deleteById,
            updateCenterTypeByIdUseCase updateById) {
        this.getAll = getAll;
        this.post = post;
        this.getById = getById;
        this.deleteById = deleteById;
        this.updateById = updateById;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<CenterTypeDTO>> getAll() {
        return ResponseEntity.ok(getAll.execute());
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CenterTypeDTO dto) {
        post.execute(dto);
        return ResponseEntity.status(201).build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/id/{id}")
    public ResponseEntity<CenterTypeDTO> getById(@PathVariable Long id) {
        CenterTypeDTO dto = getById.execute(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            deleteById.execute(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @PatchMapping("/id/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody CenterTypeDTO dto) {
        try {
            updateById.execute(id, dto);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
