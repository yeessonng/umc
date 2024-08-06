package umc.spring.service.UserService;

import umc.spring.domain.User;
import umc.spring.web.dto.UserRequestDTO;

public interface UserCommandService {
    User JoinUser(UserRequestDTO.JoinDTO request);
}