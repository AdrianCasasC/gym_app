package com.acdeveloper.gymapp.users.controller;

import com.acdeveloper.gymapp.users.model.dto.UserDTO;
import com.acdeveloper.gymapp.users.service.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "users")
public class UserController {

    private final UserServiceInterface userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        Optional<UserDTO> userDTO = userService.getUserById(id);
        return userDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO newUser) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.addNewUser(newUser));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> editUserById(@PathVariable String id,@RequestBody UserDTO editedUser) {
        Optional<UserDTO> userDTO = userService.editUserById(id, editedUser);
        return userDTO.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String id) {
        return userService.deleteUserById(id);
    }
}
