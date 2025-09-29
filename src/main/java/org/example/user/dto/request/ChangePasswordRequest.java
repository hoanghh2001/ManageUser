package org.example.user.dto.request;

public record ChangePasswordRequest(
        Integer id,
        String oldPassword,
        String newPassword
) {
}
