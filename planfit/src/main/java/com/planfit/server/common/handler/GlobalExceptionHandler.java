package com.planfit.server.common.handler;

import com.planfit.server.common.ApiResponseUtil;
import com.planfit.server.common.BaseResponse;
import com.planfit.server.common.exception.NotFoundException;
import com.planfit.server.common.exception.BadRequestException;
import com.planfit.server.common.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<BaseResponse<?>> handleNotFoundException(NotFoundException e) {
        return ApiResponseUtil.failure(e.getErrorMessage());
    } 
  
    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<BaseResponse<?>> handleBadRequestException(final BadRequestException e) {
        return ApiResponseUtil.failure(e.getErrorMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ApiResponseUtil.validFailure(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }
}
