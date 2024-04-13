package com.acdeveloper.gymapp.users.service;

import com.acdeveloper.gymapp.users.model.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    List<UserDTO> getAllUsers();

    Optional<UserDTO> getUserById(String userId);

    UserDTO addNewUser(@Valid UserDTO newUser);

    Optional<UserDTO> editUserById(String userId,@Valid UserDTO editedUser);

    ResponseEntity<Void> deleteUserById(String userId);
}
