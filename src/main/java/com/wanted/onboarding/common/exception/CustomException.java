package com.wanted.onboarding.common.exception;

import com.wanted.onboarding.common.response.ErrorCode;
import lombok.Getter;

@Getter
public class CustomException extends  RuntimeException{

    private final ErrorCode errorCode;

    public CustomException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
