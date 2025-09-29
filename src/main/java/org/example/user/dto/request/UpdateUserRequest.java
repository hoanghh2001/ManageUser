package org.example.user.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.example.user.model.Gender;

import java.time.LocalDate;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateUserRequest(

        @Size(max = 100, message = "tên không được quá 100 kí tự")
        String name,

        Gender gender,

        @Past(message = "vui lòng điền ngày sinh hợp lệ, ngày sinh không được ở tương lai")
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate birthday,

        @Pattern(regexp = "^[0-9+\\-]{8,20}$", message = "số điện thoại không hợp lệ")
        String phone

) {
}
