package com.planfit.server.common.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorMessage {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "해당 사용자가 존재하지 않습니다."),
    EXERCISE_BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "운동리스트 조회에 실패했습니다."),
    ;

    private final HttpStatus status;
    private final String message;
}
