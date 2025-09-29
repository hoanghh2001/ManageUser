package org.example.user.dto.request;

import org.example.user.model.Gender;

import java.time.LocalDate;

public record UpdateUserRequest(
        Integer id,
        String name,
        Gender gender,
        LocalDate birthday,
        String phone

) {
}
