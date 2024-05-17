package com.planfit.server.common;

import com.planfit.server.common.message.ErrorMessage;
import com.planfit.server.common.message.SuccessMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ApiResponseUtil {
    static ResponseEntity<BaseResponse<?>> success(SuccessMessage successMessage) {
        return ResponseEntity.status(successMessage.getStatus())
                .body(BaseResponse.of(successMessage));
    }

    static <T> ResponseEntity<BaseResponse<?>> success(SuccessMessage successMessage, T data) {
        return ResponseEntity.status(successMessage.getStatus())
                .body(BaseResponse.of(successMessage, data));
    }

    static ResponseEntity<BaseResponse<?>> failure(ErrorMessage errorMessage) {
        return ResponseEntity.status(errorMessage.getStatus())
                .body(BaseResponse.of(errorMessage));
    }

        static ResponseEntity<BaseResponse<?>> validFailure(String errorMessage) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(BaseResponse.of(errorMessage));
    }
}
