package com.planfit.server.dto.request;

public record UserPutRequest(
        int minute,
        String condition
) {
}
