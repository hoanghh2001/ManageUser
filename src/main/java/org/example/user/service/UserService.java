package org.example.user.service;

import org.example.user.dto.request.CreateUserRequest;
import org.example.user.dto.request.UpdateUserRequest;
import org.example.user.dto.response.UserResponse;
import org.example.user.model.User;
import org.example.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponse createUser(CreateUserRequest r);
    UserResponse updateUser(Integer id,UpdateUserRequest r);

    List<UserResponse> findAllUser();
    List<UserResponse> findAllActive();
    List<UserResponse> findAllDeleted();
    Optional<UserResponse> findById(int id);
    Optional<UserResponse> findByEmail(String email);
    boolean existsByEmail(String email);
    int softDeleteById(int id);
    int hardDeleteById(int id);

}
