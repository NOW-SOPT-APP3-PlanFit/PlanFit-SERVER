package com.planfit.server.common.exception;

import com.planfit.server.common.message.ErrorMessage;

public class IndexOutOfBoundsException extends PlanfitException {
    public IndexOutOfBoundsException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
