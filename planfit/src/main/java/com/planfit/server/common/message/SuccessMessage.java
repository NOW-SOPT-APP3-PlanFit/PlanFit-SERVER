package com.planfit.server.common.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessMessage {

    EXERCISES_FIND_SUCCESS(HttpStatus.OK.value(), "운동 리스트 조회에 성공했습니다.")

    ;
    private final int status;
    private final String message;
}
