package com.planfit.server.common.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorMessage {

    //user
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 사용자가 존재하지 않습니다."),

    //exercise
    EXERCISE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 운동이 존재하지 않습니다."),
    EXERCISE_BAD_REQUEST(HttpStatus.BAD_REQUEST, "운동리스트 조회에 실패했습니다."),

    //routine
    ROUTINE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 루틴이 존재하지 않습니다."),
    ROUTINE_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "이미 루틴이 존재합니다."),

    //set
    SET_OVER_INDEX_REQUEST(HttpStatus.BAD_REQUEST, "이미 모든 세트가 완료 상태입니다")
    ;

    private final HttpStatus status;
    private final String message;
}
