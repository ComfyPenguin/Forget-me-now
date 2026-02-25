package com.bloste_software.remmy_server.infraestructure.controlers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bloste_software.remmy_server.application.usecases.centercharacteristic.*;
import com.bloste_software.remmy_server.presentation.dtos.CenterCharacteristicDTO;

@RestController
@RequestMapping("/center_characteristic")
public class CenterCharacteristicController {
    private final getAllCenterCharacteristicsUseCase getAll;
    private final postCenterCharacteristicUseCase post;
    private final getCenterCharacteristicByIdUseCase getById;
    private final deleteCenterCharacteristicByIdUseCase deleteById;
    private final updateCenterCharacteristicByIdUseCase updateById;

    public CenterCharacteristicController(getAllCenterCharacteristicsUseCase getAll, postCenterCharacteristicUseCase post, getCenterCharacteristicByIdUseCase getById, deleteCenterCharacteristicByIdUseCase deleteById, updateCenterCharacteristicByIdUseCase updateById) {
        this.getAll = getAll; this.post = post; this.getById = getById; this.deleteById = deleteById; this.updateById = updateById;
    }

    @CrossOrigin(origins = "*") @GetMapping
    public ResponseEntity<List<CenterCharacteristicDTO>> getAll() { return ResponseEntity.ok(getAll.execute()); }

    @CrossOrigin(origins = "*") @PostMapping
    public ResponseEntity<Void> create(@RequestBody CenterCharacteristicDTO dto) { post.execute(dto); return ResponseEntity.status(201).build(); }

    @CrossOrigin(origins = "*") @GetMapping("/id/{id}")
    public ResponseEntity<CenterCharacteristicDTO> getById(@PathVariable Long id) {
        CenterCharacteristicDTO dto = getById.execute(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*") @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try { deleteById.execute(id); return ResponseEntity.noContent().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }

    @CrossOrigin(origins = "*") @PatchMapping("/id/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody CenterCharacteristicDTO dto) {
        try { updateById.execute(id, dto); return ResponseEntity.ok().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }
}
