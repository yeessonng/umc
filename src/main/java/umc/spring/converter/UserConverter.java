package umc.spring.converter;

import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;
import umc.spring.domain.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDTO request){
        Gender gender = null;
        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        LocalDate birth = LocalDate.of(request.getBrithYear(), request.getBirthMonth(), request.getBirthDay());

        return User.builder()
                .name(request.getName())
                .gender(gender)
                .address(request.getAddress())
                .brith(birth)
                .userFoodList(new ArrayList<>())
                .build();
    }
}
