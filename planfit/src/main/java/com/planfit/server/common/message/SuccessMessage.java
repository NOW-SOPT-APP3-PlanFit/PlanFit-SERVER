package com.planfit.server.common.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessMessage {

    USER_MAIN_GET_SUCCESS(HttpStatus.OK.value(), "회원의 메인 화면 조회가 완료되었습니다."),
    USER_PUT_SUCCESS(HttpStatus.OK.value(), "회원 정보 수정이 완료되었습니다."),
    ;
    private final int status;
    private final String message;
}
