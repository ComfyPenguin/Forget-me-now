package com.bloste_software.remmy_server.infraestructure.controlers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloste_software.remmy_server.application.usecases.user.getAllUsersUseCase;
import com.bloste_software.remmy_server.application.usecases.user.postUserUseCase;
import com.bloste_software.remmy_server.presentation.dtos.UserDTO;





@RestController
@RequestMapping("/User")
public class UserController {

    private final getAllUsersUseCase getAllUsers;
    private final postUserUseCase postUser;
 
    
    public UserController(
            getAllUsersUseCase getAllUsers,
            postUserUseCase postUser) {

        this.getAllUsers = getAllUsers;
        this.postUser = postUser;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(getAllUsers.execute());
    }

    @CrossOrigin(origins = "*")
    @PostMapping
       public ResponseEntity<Void> create(@RequestBody UserDTO user) {
        postUser.execute(user);
        return ResponseEntity.status(201).build();
    }
}