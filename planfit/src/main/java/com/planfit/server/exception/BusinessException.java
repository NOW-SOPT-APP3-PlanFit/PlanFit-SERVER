package com.planfit.server.exception;

import com.planfit.server.common.message.ErrorMessage;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
