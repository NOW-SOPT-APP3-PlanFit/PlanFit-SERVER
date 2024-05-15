package com.planfit.server.common.exception;

import com.planfit.server.common.message.ErrorMessage;

public class NotFoundException extends PlanfitException {

    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
