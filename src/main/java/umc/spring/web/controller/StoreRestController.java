package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.validation.annotation.ExistDistrict;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/{districtId}/add")
    public ApiResponse<StoreResponseDTO.StoreResultDTO> join(@RequestBody @Valid StoreRequestDTO.StoreAddDTO request,
                                                             @ExistDistrict @PathVariable(name = "districtId") Long districtId){
        Store store = storeCommandService.checkStore(request, districtId);
        return ApiResponse.onSuccess(StoreConverter.StoreToDTO(store));
    }
}
