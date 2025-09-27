package org.example.mapper;

import org.example.user.dto.DtoUser;
import org.example.user.model.User;

public class UserMapper{
    public static DtoUser toDto(User u){
        if (u == null) return null;
        return new DtoUser(
                u.getId(),
                u.getGender(),
                u.getBirthday(),
                u.getPhone(),
                u.getEmail(),
                u.getCreated_at(),
                u.getUpdated_at()
        );
    }
    public static User toUser(DtoUser d){
        if (d == null) return null;
        return new User(
                d.id(),
                d.gender(),
                d.birthday(),
                d.phone(),
                d.email(),
                d.created_at(),
                d.updated_at()
        );
    }

}
