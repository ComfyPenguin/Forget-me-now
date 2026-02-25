package com.bloste_software.remmy_server.infraestructure.controlers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bloste_software.remmy_server.application.usecases.center.*;
import com.bloste_software.remmy_server.presentation.dtos.CenterDTO;

@RestController
@RequestMapping("/center")
public class CenterController {

    private final getAllCentersUseCase getAllCenters;
    private final postCenterUseCase postCenter;
    private final getCenterByIdUseCase getCenterById;
    private final deleteCenterByIdUseCase deleteCenterById;
    private final updateCenterByIdUseCase updateCenterById;

    public CenterController(
            getAllCentersUseCase getAllCenters,
            postCenterUseCase postCenter,
            getCenterByIdUseCase getCenterById,
            deleteCenterByIdUseCase deleteCenterById,
            updateCenterByIdUseCase updateCenterById) {
        this.getAllCenters = getAllCenters;
        this.postCenter = postCenter;
        this.getCenterById = getCenterById;
        this.deleteCenterById = deleteCenterById;
        this.updateCenterById = updateCenterById;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<CenterDTO>> getAll() {
        return ResponseEntity.ok(getAllCenters.execute());
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CenterDTO center) {
        postCenter.execute(center);
        return ResponseEntity.status(201).build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/id/{id}")
    public ResponseEntity<CenterDTO> getById(@PathVariable Long id) {
        CenterDTO center = getCenterById.execute(id);
        if (center != null) {
            return ResponseEntity.ok(center);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            deleteCenterById.execute(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @PatchMapping("/id/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody CenterDTO center) {
        try {
            updateCenterById.execute(id, center);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
