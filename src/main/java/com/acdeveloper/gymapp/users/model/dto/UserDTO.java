package com.acdeveloper.gymapp.users.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class UserDTO {

    private String id;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    private Integer age;

    @NonNull
    private String email;
}
