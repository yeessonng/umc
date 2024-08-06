package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.domain.Food;
import umc.spring.domain.User;
import umc.spring.domain.common.BaseEntity;

import static org.apache.commons.lang3.BooleanUtils.TRUE;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class UserFood extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ColumnDefault(TRUE)
    private Boolean required;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    public void setUser(User user){
        if(this.user != null)
            user.getUserFoodList().remove(this);
        this.user = user;
        user.getUserFoodList().add(this);
    }

    public void setFood(Food food){
        this.food = food;
    }
}