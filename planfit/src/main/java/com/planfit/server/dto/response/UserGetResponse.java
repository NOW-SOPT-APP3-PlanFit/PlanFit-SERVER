package com.planfit.server.dto.response;

import com.planfit.server.domain.User;

public record UserGetResponse(
        int round,
        int minute,
        String condition
) {
    public static UserGetResponse of(User user) {
        return new UserGetResponse(
                user.getRound(),
                user.getMinute(),
                user.getCondition()
        );
    }
}
