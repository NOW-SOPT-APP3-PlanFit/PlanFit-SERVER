package com.planfit.server.controller;

import com.planfit.server.common.ApiResponseUtil;
import com.planfit.server.common.BaseResponse;
import com.planfit.server.common.message.SuccessMessage;
import com.planfit.server.dto.request.UserPutRequest;
import com.planfit.server.dto.response.UserGetResponse;
import com.planfit.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.path}")
public class UserController {

    private final UserService userService;

    @GetMapping("/main")
    public ResponseEntity<BaseResponse<?>> getUser(
            @RequestHeader(name = "user_id") Long userId
    ) {
        return ApiResponseUtil.success(
                SuccessMessage.USER_MAIN_GET_SUCCESS,
                UserGetResponse.of(userService.getUserById(userId))
        );
    }

    @PutMapping("/main")
    public ResponseEntity<BaseResponse<?>> putUser(
            @RequestHeader(name = "user_id") Long userId,
            @RequestBody UserPutRequest request
    ) {
        userService.updateUser(userId, request);

        return ApiResponseUtil.success(
                SuccessMessage.USER_PUT_SUCCESS
        );
    }
}
