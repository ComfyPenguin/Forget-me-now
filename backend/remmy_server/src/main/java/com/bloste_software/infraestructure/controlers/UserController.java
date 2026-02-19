package com.bloste_software.infraestructure.controlers;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloste_software.application.usecases.user.getAllUsersUseCase;
import com.bloste_software.presentation.dtos.UserDTO;





@RestController
@RequestMapping("/User")
public class UserController {

    private final getAllUsersUseCase getAllUsers;
 
    
    public UserController(
            getAllUsersUseCase getAllUsers) {

        this.getAllUsers = getAllUsers;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(getAllUsers.execute());
    }

}