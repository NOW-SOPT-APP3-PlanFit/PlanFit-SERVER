package com.planfit.server.common.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorMessage {

    EXERCISE_BAD_REQUEST(HttpStatus.BAD_REQUEST, "운동리스트 조회에 실패했습니다."),
    EXERCISE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당되는 운동이 존재하지 않습니다.")

    ;

    private final HttpStatus status;
    private final String message;
}
