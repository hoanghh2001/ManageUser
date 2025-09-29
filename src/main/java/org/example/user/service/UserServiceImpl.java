package org.example.user.service;

import org.apache.catalina.mapper.Mapper;
import org.example.user.dto.request.CreateUserRequest;
import org.example.user.dto.request.UpdateUserRequest;
import org.example.user.dto.response.UserResponse;
import org.example.user.mapper.UserMapper;
import org.example.user.model.User;
import org.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    public UserServiceImpl(UserRepository repo){
        this.repo=repo;
    }
    @Override
    public UserResponse createUser(CreateUserRequest r) {
        User u = UserMapper.toEntity(r);
        repo.save(u);
        return UserMapper.toResponse(u);
    }

    @Override
    public UserResponse updateUser(Integer id, UpdateUserRequest r) {
        User u = repo.findById(id).orElseThrow(()->new RuntimeException("không tìm thấy người dùng"));
        User rs = UserMapper.merge(r,u);
        repo.save(rs);
        return UserMapper.toResponse(rs);
    }

    @Override
    public List<UserResponse> findAllUser() {
        return repo.findAll().stream()
                .map(UserMapper::toResponse).toList();
    }

    @Override
    public List<UserResponse> findAllActive() {
        return repo.findByDeletedFalse().stream()
                .map(UserMapper::toResponse).toList();
    }

    @Override
    public List<UserResponse> findAllDeleted() {
        return repo.findByDeletedTrue().stream()
                .map(UserMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserResponse> findById(int id) {
        return repo.findById(id).map(UserMapper::toResponse);
    }

    @Override
    public Optional<UserResponse> findByEmail(String email) {
        return repo.findByEmail(email).map(UserMapper::toResponse);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repo.existsByEmail(email);
    }

    @Override
    public int softDeleteById(int id) {
        return repo.softDeleteById(id);
    }

    @Override
    public int hardDeleteById(int id) {
        return repo.deleteById(id);
    }
}
