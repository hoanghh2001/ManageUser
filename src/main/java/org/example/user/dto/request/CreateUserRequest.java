package org.example.user.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import org.example.user.model.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateUserRequest (
        @NotBlank(message = "tên không được trống")
        @Size( max=100,message = "tên không được quá 100 kí tự")
        String name,

        @NotNull(message = "vui lòng điền giới tính")
        Gender gender,

        @Past(message = "vui lòng điền ngày sinh hợp lệ, ngày sinh không được ở tương lai")
        @NotNull(message = "vui lòng điền ngày sinh")
        LocalDate birthday,

        @Pattern(regexp ="^[0-9+\\-]{8,20}$",message = "số điện thoại không hợp lệ")
        String phone,

        @NotBlank(message = "vui lòng điền email")
        @Email(message ="email không hợp lệ")
        @Size(max = 255,message = "email quá dài")
        String email,

        @NotBlank(message = "vui lòng điền mật khẩu")
        @Size(min = 8,max = 100, message = "mật khẩu phải từ 8-100 kí tự")
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        String password
        ){

}
