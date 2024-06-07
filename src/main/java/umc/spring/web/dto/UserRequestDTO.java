package umc.spring.web.dto;

import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class MemberRequestDTO {
    @Getter
    public static class JoinDto{
        String name;
        String gender;
        Date birth;
        String address;
        List<Long> preferFood;
    }
}
