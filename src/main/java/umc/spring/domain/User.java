package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.SnsStatus;
import umc.spring.domain.enums.UserStatus;
import umc.spring.domain.mapping.UserAgree;
import umc.spring.domain.mapping.UserFood;
import umc.spring.domain.mapping.UserMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(10) NOT NULL")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10) NOT NULL")
    private Gender gender;

    @Column(columnDefinition = "DATE NOT NULL")
    private LocalDate brith;

    @Column(nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private SnsStatus snsType;

    @Column(length = 10)
    private String nickname;

    @Column(length = 20)
    private String phoneNum;

    @Column(length = 40)
    private String email;

    @Column(columnDefinition = "int DEFAULT 0")
    private Integer point;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) NOT NULL DEFAULT 'ACTIVE'")
    private UserStatus status;

    private LocalDate inactiveDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ask> askList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFood> userFoodList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserAgree> userAgreeList = new ArrayList<>();
}
