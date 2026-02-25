package com.bloste_software.remmy_server.infraestructure.controlers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bloste_software.remmy_server.application.usecases.city.*;
import com.bloste_software.remmy_server.presentation.dtos.CityDTO;

@RestController
@RequestMapping("/city")
public class CityController {
    private final getAllCitiesUseCase getAll;
    private final postCityUseCase post;
    private final getCityByIdUseCase getById;
    private final deleteCityByIdUseCase deleteById;
    private final updateCityByIdUseCase updateById;

    public CityController(getAllCitiesUseCase getAll, postCityUseCase post, getCityByIdUseCase getById, deleteCityByIdUseCase deleteById, updateCityByIdUseCase updateById) {
        this.getAll = getAll; this.post = post; this.getById = getById; this.deleteById = deleteById; this.updateById = updateById;
    }

    @CrossOrigin(origins = "*") @GetMapping
    public ResponseEntity<List<CityDTO>> getAll() { return ResponseEntity.ok(getAll.execute()); }

    @CrossOrigin(origins = "*") @PostMapping
    public ResponseEntity<Void> create(@RequestBody CityDTO dto) { post.execute(dto); return ResponseEntity.status(201).build(); }

    @CrossOrigin(origins = "*") @GetMapping("/id/{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable Long id) {
        CityDTO dto = getById.execute(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*") @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try { deleteById.execute(id); return ResponseEntity.noContent().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }

    @CrossOrigin(origins = "*") @PatchMapping("/id/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody CityDTO dto) {
        try { updateById.execute(id, dto); return ResponseEntity.ok().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }
}
