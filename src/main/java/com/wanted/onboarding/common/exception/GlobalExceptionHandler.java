package com.wanted.onboarding.common.exception;

import com.wanted.onboarding.common.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.wanted.onboarding.common.response.ErrorCode.COMMON_JSON_PROCESSING_ERROR;
import static com.wanted.onboarding.common.response.ErrorCode.COMMON_RESOURCE_NOT_FOUND;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String ERROR_MESSAGE_DELIMITER = "," + System.lineSeparator();


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<CommonResponse<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("[HandleMethodArgumentNotValidException]", e);
        BindingResult bindingResult = e.getBindingResult();

        List<String> errorMessage = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessage.add("[" + fieldError.getField() + "] " + fieldError.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(CommonResponse.error(String.join(
                ERROR_MESSAGE_DELIMITER,
                errorMessage)
        ));
    }


    /**
     * NoResourceFoundException 예외 처리
     * */
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity<CommonResponse<Void>> handleNoResourceFoundException(NoResourceFoundException e) {
        log.error("[NoResourceFoundException] URL = {}, Message = {}", e.getResourcePath(), e.getMessage());
        return new ResponseEntity(CommonResponse.error(COMMON_RESOURCE_NOT_FOUND.getMessage()), NOT_FOUND);
    }


    /**
     * HTTP 요청 메시지의 형식이 올바르지 않거나 JSON 데이터가 읽을 수 없을 때
     * */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CommonResponse<Void>> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("[HttpMessageNotReadableException] Message = {}", e.getMessage());
        return ResponseEntity.badRequest().body(CommonResponse.error(COMMON_JSON_PROCESSING_ERROR.getMessage()));
    }

    /**
     * 구체적인 예외 타입이 매칭되지 않을 시
     * */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<CommonResponse<Void>> handleException(Exception e) {
        log.error("[Exception] Message = {}", e.getMessage(), e);
        return new ResponseEntity<>(CommonResponse.error(), INTERNAL_SERVER_ERROR);
    }

    /**
     *  요청된 요소가 존재하지 않을 때
     * */
    @ExceptionHandler(NoSuchElementException.class)
    public CommonResponse<Void> handleNoSuchElementException(NoSuchElementException ex) {
        return CommonResponse.error(ex.getMessage());
    }
}
