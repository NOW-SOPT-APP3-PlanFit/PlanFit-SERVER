package com.planfit.server.common.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessMessage {

    EXERCISE_LIKE_POST_SUCCESS(HttpStatus.OK, "해당 운동 좋아요 등록에 성공했습니다."),
    EXERCISE_DELETE_UNLIKE_SUCCESS(HttpStatus.OK, "해당 운동 좋아요 취소에 성공했습니다")

    ;
    private final HttpStatus status;
    private final String message;
}
