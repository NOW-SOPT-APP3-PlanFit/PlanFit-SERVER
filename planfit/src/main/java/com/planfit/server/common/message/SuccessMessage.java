package com.planfit.server.common.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessMessage {
    
    // user
    USER_MAIN_GET_SUCCESS(HttpStatus.OK, "회원의 메인 화면 조회가 완료되었습니다."),
    USER_PUT_SUCCESS(HttpStatus.OK, "회원 정보 수정이 완료되었습니다."),
  
    // exercise
    EXERCISES_FIND_SUCCESS(HttpStatus.OK, "운동 리스트 조회에 성공했습니다."),
    EXERCISES_REORDER_SUCCESS(HttpStatus.OK, "운동 리스트 순서 변경에 성공했습니다.")
    EXERCISE_LIKE_POST_SUCCESS(HttpStatus.OK, "해당 운동 좋아요 등록에 성공했습니다."),
    EXERCISE_DELETE_UNLIKE_SUCCESS(HttpStatus.OK, "해당 운동 좋아요 취소에 성공했습니다"),
    ;
  
    private final HttpStatus status;
    private final String message;
}
