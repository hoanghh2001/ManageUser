package org.example.user.dto.request;

import org.example.user.model.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CreateUserRequest (
        String name,
        Gender gender,
        LocalDate birthday,
        String phone,
        String email,
        String password
        ){

}
