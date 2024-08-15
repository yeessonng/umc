package umc.spring.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.District;
import umc.spring.domain.Store;
import umc.spring.repository.DistrictRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;

    private final DistrictRepository districtRepository;

    @Override
    public Store checkStore(StoreRequestDTO.StoreAddDTO request, Long districtId) {
        Store newStore = StoreConverter.toStore(request);

        //id 매핑
        newStore.setDistrict(districtRepository.findById(districtId).get());

        return storeRepository.save(newStore);
    }
}
