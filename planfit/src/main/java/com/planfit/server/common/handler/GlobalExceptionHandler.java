package com.planfit.server.common.handler;

import com.planfit.server.common.ApiResponseUtil;
import com.planfit.server.common.BaseResponse;
import com.planfit.server.common.exception.BadRequestException;
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
