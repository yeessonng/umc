package umc.spring.converter;

import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.domain.User;

import java.time.LocalDateTime;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return MemberResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
