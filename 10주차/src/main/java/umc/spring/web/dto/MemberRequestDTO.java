package umc.spring.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter // thymeleaf에서 사용하기위해 추가
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        Integer age;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @NotNull
        Role role; // 역할 필드 추가
        @ExistCategories
        List<Long> preferCategory;
    }

    @Getter
    @Setter
    public static class LoginRequestDTO{
        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "올바른 이메일 형식이어야 합니다.")
        private String email;
        @NotBlank(message = "패스워드는 필수입니다.")
        private String password;
    }


}
