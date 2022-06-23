package com.haesolinfo.srm.handler;


import com.haesolinfo.srm.exception.CustomValidationApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController      // 데이터 리턴.
@ControllerAdvice   // 모든 Exception 을 낚아 챔
public class ControllerExceptionHandler {

//    // 자바스크립트 응답.
//    @ExceptionHandler(CustomValidationException.class) // RuntimeException 이 발생하는 것을 이 함수가 가로챔.
//    public String validationException(CustomValidationException e) {
//        // CMRespDto, Script 비교
//        // 1.클라이언트에게 응답할 때는 Script 가 좋음.
//        // 2. Ajax 통신 - CMRepDto
//        // 3. Android 통신 - CMRespDto
//        return Script.back(e.getErrorMap().toString());
//    }

    // 오브젝트 응답.
    @ExceptionHandler(CustomValidationApiException.class) // RuntimeException 이 발생하는 것을 이 함수가 가로챔.
    public ResponseEntity<?> validationException(CustomValidationApiException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}