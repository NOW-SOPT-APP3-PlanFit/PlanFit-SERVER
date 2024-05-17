package com.planfit.server.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.planfit.server.common.message.ErrorMessage;
import com.planfit.server.common.message.SuccessMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BaseResponse<T> {
    private final int status;
    private final String message;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private final T data;

    public static BaseResponse<?> of(SuccessMessage successMessage) {
        return builder()
                .status(successMessage.getStatus().value())
                .message(successMessage.getMessage())
                .build();
    }

    public static <T> BaseResponse<?> of(SuccessMessage successMessage, T data) {
        return builder()
                .status(successMessage.getStatus().value())
                .message(successMessage.getMessage())
                .data(data)
                .build();
    }

    public static BaseResponse<?> of(ErrorMessage errorMessage) {
        return builder()
                .status(errorMessage.getStatus().value())
                .message(errorMessage.getMessage())
                .build();
    }

    public static BaseResponse<?> of(String errorMessage) {
        return builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(errorMessage)
                .build();
    }
}
