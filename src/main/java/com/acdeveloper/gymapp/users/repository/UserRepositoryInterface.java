package com.acdeveloper.gymapp.users.repository;

import com.acdeveloper.gymapp.users.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {

    List<UserEntity> getAllUsers();

    Optional<UserEntity> getUserById(String userId);

    UserEntity addNewUser(UserEntity newUser);

    Optional<UserEntity> editUserById(String userId, UserEntity editedUser);

    void deleteUserById(String userId);
}
