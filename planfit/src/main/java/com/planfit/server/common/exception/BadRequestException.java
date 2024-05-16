package com.planfit.server.common.exception;

import com.planfit.server.common.message.ErrorMessage;

public class BadRequestException extends PlanfitException {

    public BadRequestException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
