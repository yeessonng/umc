package umc.spring.converter;

import umc.spring.domain.District;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

public class StoreConverter {
    public static StoreResponseDTO.StoreResultDTO StoreToDTO(Store store) {
        return StoreResponseDTO.StoreResultDTO.builder()
                .storeId(store.getId())
                .build();
    } //response : entity to dto

    public static Store toStore(StoreRequestDTO.StoreAddDTO request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .build();
    }

}