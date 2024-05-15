package com.planfit.server.common.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessMessage {

    POST_EXERCISE_LIKE_SUCCESS(HttpStatus.OK, "해당 운동에 좋아요를 눌렀습니다."),
    DELETE_EXERCISE_UNLIKE_SUCCESS(HttpStatus.OK, "해당 운동에 좋아요를 취소했습니다.")

    ;
    private final HttpStatus status;
    private final String message;
}
