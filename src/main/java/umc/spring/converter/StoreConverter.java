package umc.spring.converter;

import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import umc.spring.domain.District;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        StoreResponseDTO.ReviewPreViewDTO dto = StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName()) //유저 이름... review > user
                .star(review.getStar())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();

        // DTO 객체를 콘솔에 출력
        System.out.println("ReviewPreViewDTO: " + dto);

        return dto;
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        //목록을 만드는...

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }


}