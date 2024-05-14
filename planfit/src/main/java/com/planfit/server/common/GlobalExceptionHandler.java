package com.planfit.server.common;

import com.planfit.server.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<BaseResponse<?>> handleBadRequestException(final BadRequestException e) {
        return ApiResponseUtil.failure(e.getErrorMessage());
    }
}
