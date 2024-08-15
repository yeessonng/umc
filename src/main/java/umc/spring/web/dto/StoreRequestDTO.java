package umc.spring.web.dto;
import lombok.Getter;

import java.time.LocalTime;

public class StoreRequestDTO {
    @Getter
    public static class StoreAddDTO{
        String name;
        String address;
        LocalTime startTime;
        LocalTime endTime;
    }
}
