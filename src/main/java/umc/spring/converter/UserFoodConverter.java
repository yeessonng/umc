package umc.spring.converter;

import umc.spring.domain.Food;
import umc.spring.domain.mapping.UserFood;

import java.util.List;
import java.util.stream.Collectors;

public class UserFoodConverter {
    public static List<UserFood> toUserFoodList(List<Food> foodList) {
        return foodList.stream()
                .map(food -> // userfood의 food 객체 (선호하는 food)
                        UserFood.builder()
                                .food(food)
                                .required(Boolean.TRUE)
                                .build()
                ).collect(Collectors.toList());
    }
}
