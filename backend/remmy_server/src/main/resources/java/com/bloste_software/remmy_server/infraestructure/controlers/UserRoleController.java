package com.bloste_software.remmy_server.infraestructure.controlers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bloste_software.remmy_server.application.usecases.userrole.*;
import com.bloste_software.remmy_server.presentation.dtos.UserRoleDTO;

@RestController
@RequestMapping("/user_role")
public class UserRoleController {
    private final getAllUserRolesUseCase getAll;
    private final postUserRoleUseCase post;
    private final getUserRoleByIdUseCase getById;
    private final deleteUserRoleByIdUseCase deleteById;
    private final updateUserRoleByIdUseCase updateById;

    public UserRoleController(getAllUserRolesUseCase getAll, postUserRoleUseCase post, getUserRoleByIdUseCase getById, deleteUserRoleByIdUseCase deleteById, updateUserRoleByIdUseCase updateById) {
        this.getAll = getAll; this.post = post; this.getById = getById; this.deleteById = deleteById; this.updateById = updateById;
    }

    @CrossOrigin(origins = "*") @GetMapping
    public ResponseEntity<List<UserRoleDTO>> getAll() { return ResponseEntity.ok(getAll.execute()); }

    @CrossOrigin(origins = "*") @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserRoleDTO dto) { post.execute(dto); return ResponseEntity.status(201).build(); }

    @CrossOrigin(origins = "*") @GetMapping("/id/{id}")
    public ResponseEntity<UserRoleDTO> getById(@PathVariable Long id) {
        UserRoleDTO dto = getById.execute(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*") @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try { deleteById.execute(id); return ResponseEntity.noContent().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }

    @CrossOrigin(origins = "*") @PatchMapping("/id/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody UserRoleDTO dto) {
        try { updateById.execute(id, dto); return ResponseEntity.ok().build(); }
        catch (RuntimeException e) { return ResponseEntity.notFound().build(); }
    }
}
