package umc.spring.service.StoreService;

import umc.spring.domain.District;

import java.util.Optional;

public interface StoreQueryService {
    Optional<District> findDistrict(Long id);
}
