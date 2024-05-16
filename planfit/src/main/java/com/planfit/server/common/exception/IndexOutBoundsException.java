package com.planfit.server.common.exception;

import com.planfit.server.common.message.ErrorMessage;

public class IndexOutBoundsException extends PlanfitException {
    public IndexOutBoundsException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
