package org.example.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "users",
        indexes ={ @Index(name = "ix_users_email", columnList = "email", unique = true),
        @Index(name = "ix_users_phone", columnList = "phone")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    @NotBlank(message = "name không được trống")
    private String name;
    @Enumerated(EnumType.STRING) // hoặc STRING ngắn như "M","F"
    @Column(nullable = false, length = 10)
    private Gender gender;
    @Past(message = "birthday phải ở quá khứ")
    private LocalDate birthday;
    @Column(length = 20)
    private String phone;
    @Email(message = "email không hợp lệ")
    @Column(nullable = false, unique = true, length = 255)
    private String email;
    @JsonIgnore // không trả password ra JSON (API)
    @Column(nullable = false, length = 255)
    private String password;
    @Column(nullable = false)
    private boolean deleted;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;
    protected User(){}


    public User(Integer id, String name, Gender gender, LocalDate birthday, String phone, String email,String password, boolean deleted, LocalDateTime created_at, LocalDateTime updated_at, LocalDateTime deleted_at) {
            this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.password=password;
        this.deleted = deleted;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;

    }
    public User(String name, Gender gender, LocalDate birthday,
                String phone, String email, String password) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.deleted = false;
        this.created_at = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at() {
        this.updated_at = updated_at;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", deleted=" + deleted +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                '}';
    }
}
