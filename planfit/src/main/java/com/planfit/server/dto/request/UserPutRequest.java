package com.planfit.server.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record UserPutRequest(

        @Min(value = 1, message = "0분보다 커야 됩니다.")
        @Max(value = 59, message = "59분보다 작아야 됩니다.")
        int minute,
        String condition
) {
}
