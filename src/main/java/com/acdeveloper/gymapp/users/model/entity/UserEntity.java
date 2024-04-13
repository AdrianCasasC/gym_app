package com.acdeveloper.gymapp.users.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntity {

    private String id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
}
