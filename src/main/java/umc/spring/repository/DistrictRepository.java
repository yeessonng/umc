package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import umc.spring.domain.District;

import java.util.List;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Long> {
    @Query("SELECT d.name FROM District d")
    List<String> findAllNames();

    // 이름으로 District 엔티티를 조회하는 메서드
    Optional<District> findByName(String name);
}
