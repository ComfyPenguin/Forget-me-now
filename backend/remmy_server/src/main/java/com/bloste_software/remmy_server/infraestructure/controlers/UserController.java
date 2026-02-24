package com.bloste_software.remmy_server.infraestructure.controlers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloste_software.remmy_server.application.usecases.user.DeleteUserByEmailUseCase;
import com.bloste_software.remmy_server.application.usecases.user.DeleteUserByIdUseCase;
import com.bloste_software.remmy_server.application.usecases.user.UpdateUserByEmailUseCase;
import com.bloste_software.remmy_server.application.usecases.user.UpdateUserByIdUseCase;
import com.bloste_software.remmy_server.application.usecases.user.getAllUsersUseCase;
import com.bloste_software.remmy_server.application.usecases.user.getUserByIdUseCase;
import com.bloste_software.remmy_server.application.usecases.user.postUserUseCase;
import com.bloste_software.remmy_server.presentation.dtos.UserDTO;





@RestController
@RequestMapping("/User")
public class UserController {

    private final getAllUsersUseCase getAllUsers;
    private final postUserUseCase postUser;
    private final DeleteUserByEmailUseCase deleteUserByEmail;
    private final UpdateUserByEmailUseCase updateUserByEmail;
    private final UpdateUserByIdUseCase updateUserById;
    private final getUserByIdUseCase getUserById;
    private final DeleteUserByIdUseCase deleteUserById;
 
    
    public UserController(
            getAllUsersUseCase getAllUsers,
            postUserUseCase postUser,
            DeleteUserByEmailUseCase deleteUserByEmail,
            UpdateUserByEmailUseCase updateUserByEmail,
            UpdateUserByIdUseCase updateUserById,
            getUserByIdUseCase getUserById,
            DeleteUserByIdUseCase deleteUserById) {

        this.getAllUsers = getAllUsers;
        this.postUser = postUser;
        this.deleteUserByEmail = deleteUserByEmail;
        this.updateUserByEmail = updateUserByEmail;
        this.updateUserById = updateUserById;
        this.getUserById = getUserById;
        this.deleteUserById = deleteUserById;
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

    @CrossOrigin(origins = "*")
    @DeleteMapping("/email/{email}")
    public ResponseEntity<Void> delete(@PathVariable String email) {
        try {
            deleteUserByEmail.execute(email);
            return ResponseEntity.noContent().build(); // 204 és més habitual per deletes
        } catch ( RuntimeException e ) {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @PatchMapping("/email/{email}")
    public ResponseEntity<Void> update(@PathVariable String email, @RequestBody UserDTO user) {
        try {
            updateUserByEmail.execute(email, user.getUsername(), user.getPassword());
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        UserDTO user = getUserById.execute(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            deleteUserById.execute(id);
            return ResponseEntity.noContent().build(); // 204 és més habitual per deletes
        } catch ( RuntimeException e ) {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @PatchMapping("/id/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody UserDTO user) {
        try {
            updateUserById.execute(id, user);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}