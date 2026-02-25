package com.bloste_software.remmy_server.infraestructure.controlers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bloste_software.remmy_server.application.usecases.location.*;
import com.bloste_software.remmy_server.presentation.dtos.LocationDTO;

@RestController
@RequestMapping("/location")
public class LocationController {
    private final getAllLocationsUseCase getAll;
    private final postLocationUseCase post;
    private final getLocationByIdUseCase getById;
    private final deleteLocationByIdUseCase deleteById;
    private final updateLocationByIdUseCase updateById;

    public LocationController(getAllLocationsUseCase getAll, postLocationUseCase post, getLocationByIdUseCase getById, deleteLocationByIdUseCase deleteById, updateLocationByIdUseCase updateById) {
        this.getAll = getAll; this.post = post; this.getById = getById; this.deleteById = deleteById; this.updateById = updateById;
    }

    @CrossOrigin(origins = "*") @GetMapping
    public ResponseEntity<List<LocationDTO>> getAll() { return ResponseEntity.ok(getAll.execute()); }

    @CrossOrigin(origins = "*") @PostMapping
    public ResponseEntity<Void> create(@RequestBody LocationDTO dto) { post.execute(dto); return ResponseEntity.status(201).build(); }

    @CrossOrigin(origins = "*") @GetMapping("/id/{id}")
    public ResponseEntity<LocationDTO> getById(@PathVariable Integer id) {
        LocationDTO dto = getById.execute(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*") @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        try { deleteById.execute(id); return ResponseEntity.noContent().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }

    @CrossOrigin(origins = "*") @PatchMapping("/id/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Integer id, @RequestBody LocationDTO dto) {
        try { updateById.execute(id, dto); return ResponseEntity.ok().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }
}
