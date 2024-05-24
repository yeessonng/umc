package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.UserAgree;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class ServiceAgree extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String title;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private Boolean required;

    @OneToMany(mappedBy = "serviceAgree", cascade = CascadeType.ALL)
    private List<UserAgree> userAgreeList = new ArrayList<>();
}
