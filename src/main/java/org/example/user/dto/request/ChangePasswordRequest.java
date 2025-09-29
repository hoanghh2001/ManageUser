package org.example.user.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChangePasswordRequest(
        Integer id,
        String oldPassword,
        String newPassword
) {
}
