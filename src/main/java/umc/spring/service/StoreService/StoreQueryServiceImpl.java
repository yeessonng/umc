package umc.spring.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.District;
import umc.spring.repository.DistrictRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService{
    private final DistrictRepository districtRepository;

    @Override
    public Optional<District> findDistrict(Long id) {
        return districtRepository.findById(id);
    }
}
