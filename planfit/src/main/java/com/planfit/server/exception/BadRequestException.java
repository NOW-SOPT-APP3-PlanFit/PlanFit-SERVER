package com.planfit.server.exception;

import com.planfit.server.common.message.ErrorMessage;

public class BadRequestException extends BusinessException {

    public BadRequestException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
