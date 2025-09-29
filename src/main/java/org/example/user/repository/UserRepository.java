package org.example.user.repository;


import jakarta.transaction.Transactional;
import org.example.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
    boolean existsByPhone(String phone);
    boolean existsByEmail(String email);
    @Modifying
    @Transactional
    @Query("update User u set u.deleted = true where u.id = :id")
    int softDeleteById(@Param("id") int id);
    int deleteById(int id);
    List<User> findByDeletedFalse();
    List<User> findByDeletedTrue();

}