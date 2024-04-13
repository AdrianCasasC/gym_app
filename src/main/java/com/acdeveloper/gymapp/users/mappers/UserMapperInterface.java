package com.acdeveloper.gymapp.users.mappers;

import com.acdeveloper.gymapp.users.model.dto.UserDTO;
import com.acdeveloper.gymapp.users.model.entity.UserEntity;

import java.util.List;

public interface UserMapperInterface {

    List<UserDTO> userEntityListToUserDTOList(List<UserEntity> userEntities);
    UserDTO userEntityToUserDTO(UserEntity userEntity);
    UserEntity userDTOToUserEntity(UserDTO userDTO);
}
