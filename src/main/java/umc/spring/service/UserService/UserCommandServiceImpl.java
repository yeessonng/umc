package umc.spring.service.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserFoodConverter;
import umc.spring.domain.User;
import umc.spring.domain.Food;
import umc.spring.domain.mapping.UserFood;
import umc.spring.repository.FoodRepository;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.apiPayload.exception.handler.FoodHandler;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {
    private final FoodRepository foodRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User JoinUser(UserRequestDTO.JoinDTO request){
        User newUser = UserConverter.toUser(request); //user 객체 생성

        List<Food> foodList = request.getPreferFood().stream()
                .map(category -> {
                    return foodRepository.findById(category).orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserFood> userFoodList = UserFoodConverter.toUserFoodList(foodList);

        userFoodList.forEach(userFood -> {userFood.setUser(newUser);});

        return userRepository.save(newUser);
    }

    public Boolean ConfirmIsValid(List<Long> values)
    {
        boolean isValid = values.stream()
                .allMatch(value -> foodRepository.existsById(value));

        return isValid;
    }



}
