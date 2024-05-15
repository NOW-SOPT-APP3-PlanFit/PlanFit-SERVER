package com.planfit.server.common.exception;

import com.planfit.server.common.message.ErrorMessage;
import lombok.Getter;

@Getter
public class PlanfitException extends RuntimeException {

    private ErrorMessage errorMessage;

    public PlanfitException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
