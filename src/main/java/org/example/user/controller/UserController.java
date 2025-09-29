package org.example.user.controller;

import jakarta.validation.Valid;
import org.apache.catalina.mapper.Mapper;
import org.example.user.dto.request.CreateUserRequest;
import org.example.user.dto.request.UpdateUserRequest;
import org.example.user.dto.response.UserResponse;
import org.example.user.mapper.UserMapper;
import org.example.user.model.User;
import org.example.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody CreateUserRequest r){
        UserResponse saved = userService.createUser(r);
        return ResponseEntity.created(URI.create("api/users/"+saved.id())).body(saved);
    }
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<UserResponse> getById(@PathVariable int id){
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> list(@RequestParam(defaultValue = "all")String status){
        return switch (status.toLowerCase()){
            case "active" -> ResponseEntity.ok(userService.findAllActive());
            case "deleted" -> ResponseEntity.ok(userService.findAllDeleted());
            default -> ResponseEntity.ok(userService.findAllUser());
        };
    }
    @GetMapping(params = "email")
    public ResponseEntity<UserResponse> findByEmail(@RequestParam String email){
        return userService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsByEmail(@RequestParam String email){
        return ResponseEntity.ok(userService.existsByEmail(email));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable int id,@Valid @RequestBody UpdateUserRequest u){
        if (userService.findById(id).isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userService.updateUser(id,u));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> hardDelete(@PathVariable int id){
        var opt = userService.findById(id);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();
        return  ResponseEntity.noContent().build();
    }


}
