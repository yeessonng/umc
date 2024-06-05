package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.TempConverter;
import umc.spring.service.TempService.TempQueryServiceImpl;
import umc.spring.web.dto.TempResponse;
import umc.spring.service.TempService.TempQueryService;


@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor //final 필드나 @NonNull 필드에 대한 생성자를 자동으로 생성
public class TempRestController {

    private final TempQueryService tempQueryService; // 컨트롤러는 인터페이스에 의존

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}
