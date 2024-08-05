package com.wanted.onboarding.common.response;

import lombok.Getter;

import static com.wanted.onboarding.common.response.ErrorCode.COMMON_SYSTEM_ERROR;


@Getter
public class CommonResponse<T> {

    private final Status status;
    private final String message;
    private final T data;

    private CommonResponse(Status status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> ok(T data) {
        return ok(null, data);
    }

    public static <T> CommonResponse<T> ok(String message, T data) {
        return new CommonResponse<>(Status.SUCCESS, message, data);
    }

    public static CommonResponse<Void> error() {
        return error(COMMON_SYSTEM_ERROR.getMessage());
    }
    public static CommonResponse<Void> error(String message) {
        return new CommonResponse<>(Status.ERROR, message, null);
    }
}
