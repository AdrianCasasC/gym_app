package com.acdeveloper.gymapp.users.mappers;

import com.acdeveloper.gymapp.users.model.dto.UserDTO;
import com.acdeveloper.gymapp.users.model.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements UserMapperInterface{

    @Override
    public List<UserDTO> userEntityListToUserDTOList(List<UserEntity> userEntities) {
        List<UserDTO> userDTOList = new ArrayList<>();
        userEntities.forEach(userEntity -> userDTOList.add(UserDTO.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .age(userEntity.getAge())
                .email(userEntity.getEmail())
                .build()));
        return userDTOList;
    }

    @Override
    public UserDTO userEntityToUserDTO(UserEntity userEntity) {
        return UserDTO.builder()
            .id(userEntity.getId())
            .name(userEntity.getName())
            .surname(userEntity.getSurname())
            .age(userEntity.getAge())
            .email(userEntity.getEmail())
            .build();
    }

    @Override
    public UserEntity userDTOToUserEntity(UserDTO userDTO) {
        return UserEntity.builder()
            .id(userDTO.getId())
            .name(userDTO.getName())
            .surname(userDTO.getSurname())
            .age(userDTO.getAge())
            .email(userDTO.getEmail())
            .build();
    }
}
