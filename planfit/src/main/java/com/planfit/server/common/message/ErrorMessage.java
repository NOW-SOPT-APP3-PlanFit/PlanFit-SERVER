package com.planfit.server.common.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorMessage {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "해당 사용자가 존재하지 않습니다."),
    ;

    private final int status;
    private final String message;
}
