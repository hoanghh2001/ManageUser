package org.example.user.dto.response;

import org.example.user.model.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserResponse(
        Integer id,
        Gender gender,
        LocalDate birthday,
        String phone,
        String email,
        LocalDateTime created_at,
        LocalDateTime updated_at

) {
}
