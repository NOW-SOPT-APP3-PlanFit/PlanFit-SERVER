package com.planfit.server.utils;

import com.planfit.server.domain.User;
import com.planfit.server.dto.request.UserPutRequest;

public class UserTestUtil {

    public static User createUser() {
        return User.builder()
                .round(2)
                .minute(58)
                .condition("최상")
                .build();
    }

    public static UserPutRequest createPutRequest() {
        return new UserPutRequest(3, "최하");
    }
}
