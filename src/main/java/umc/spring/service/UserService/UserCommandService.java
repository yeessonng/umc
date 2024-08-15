package umc.spring.service.UserService;

import umc.spring.domain.User;
import umc.spring.web.dto.UserRequestDTO;

import java.util.List;

public interface UserCommandService {
    User JoinUser(UserRequestDTO.JoinDTO request);
    Boolean ConfirmIsValid(List<Long> values);
}