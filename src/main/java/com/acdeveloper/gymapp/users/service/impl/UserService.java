package com.acdeveloper.gymapp.users.service.impl;

import com.acdeveloper.gymapp.users.mappers.UserMapperInterface;
import com.acdeveloper.gymapp.users.model.dto.UserDTO;
import com.acdeveloper.gymapp.users.model.entity.UserEntity;
import com.acdeveloper.gymapp.users.repository.UserRepositoryInterface;
import com.acdeveloper.gymapp.users.service.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepositoryInterface userRepository;
    private final UserMapperInterface userMapper;

    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntities = userRepository.getAllUsers();

        return userMapper.userEntityListToUserDTOList(userEntities);
    }

    public Optional<UserDTO> getUserById(String userId) {
        Optional<UserEntity> userEntity = userRepository.getUserById(userId);

        return userEntity.map(userMapper::userEntityToUserDTO);
    }

    public UserDTO addNewUser(UserDTO newUser) {
        UserEntity newUserEntity = userMapper.userDTOToUserEntity(newUser);
        UserEntity userEntity = userRepository.addNewUser(newUserEntity);

        return userMapper.userEntityToUserDTO(userEntity);
    }

    public Optional<UserDTO> editUserById(String userId, UserDTO editedUser) {
        UserEntity editedUserEntity = userMapper.userDTOToUserEntity(editedUser);
        Optional<UserEntity> userEntity = userRepository.editUserById(userId, editedUserEntity);

        return userEntity.map(userMapper::userEntityToUserDTO);
    }

    @Override
    public ResponseEntity<Void> deleteUserById(String userId) {
        if (this.getUserById(userId).isPresent()) {
            userRepository.deleteUserById(userId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
