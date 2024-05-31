package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode){ // 내가 만든 에러 코드 넘어 옴
        super(errorCode); //부모 클래스 생성자 호출
    }
}
