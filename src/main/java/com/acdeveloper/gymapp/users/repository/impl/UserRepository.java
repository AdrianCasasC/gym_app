package com.acdeveloper.gymapp.users.repository.impl;

import com.acdeveloper.gymapp.users.model.entity.UserEntity;
import com.acdeveloper.gymapp.users.repository.UserRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository implements UserRepositoryInterface {

    Map<String, UserEntity> userDatabase = new HashMap<>();


    @Override
    public List<UserEntity> getAllUsers() {
        return userDatabase.values().stream().toList();
    }

    @Override
    public Optional<UserEntity> getUserById(String userId) {
        if (Objects.isNull(userDatabase.get(userId))) {
            return Optional.empty();
        }
        return Optional.of(userDatabase.get(userId));
    }

    @Override
    public UserEntity addNewUser(UserEntity newUser) {
        Random random = new Random();
        int randomId = random.nextInt();
        if (this.getUserById(Integer.toString(randomId)).isPresent()) {
            return this.addNewUser(newUser);
        }
        newUser.setId(Integer.toString(randomId));
        userDatabase.put(newUser.getId(), newUser);
        return userDatabase.get(newUser.getId());
    }

    @Override
    public Optional<UserEntity> editUserById(String userId, UserEntity editedUser) {
        Optional<UserEntity> userEntity = this.getUserById(userId);
        if (this.getUserById(userId).isPresent()) {
            userDatabase.put(userId, editedUser);
        }
        return userEntity;
    }

    @Override
    public void deleteUserById(String userId) {
        userDatabase.remove(userId);
    }
}
