package org.example.user.mapper;



import org.example.user.dto.request.CreateUserRequest;
import org.example.user.dto.request.UpdateUserRequest;
import org.example.user.dto.response.UserResponse;
import org.example.user.model.User;

public class UserMapper {
    private UserMapper(){
    }
    public static User toEntity(CreateUserRequest r){
        if (r == null) return null;
        return new User(
                r.name().trim(),
                r.gender(),
                r.birthday(),
                r.phone(),
                r.email().toLowerCase(),
                r.password()
        );
    }
    public static UserResponse toResponse(User u){
        if (u == null) return null;
        return new UserResponse(
                u.getId(),
                u.getGender(),
                u.getBirthday(),
                u.getPhone(),
                u.getEmail(),
                u.getCreated_at(),
                u.getUpdated_at()
        );
    }public static User merge(UpdateUserRequest r, User u){
        if (r.name()!=null) u.setName(r.name().trim());
        if (r.gender()!=null) u.setGender(r.gender());
        if (r.birthday()!=null) u.setBirthday(r.birthday());
        if (r.phone()!=null) u.setPhone(r.phone());
        return u;
    }
}
