package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class UserRequestDTO {
    @Getter
    public static class JoinDTO{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer brithYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        String address;
        @ExistCategories
        List<Long> preferFood; //선호 카테고리
    }
}
