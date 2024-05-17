package com.planfit.server.controller;

import com.planfit.server.common.ApiResponseUtil;
import com.planfit.server.common.BaseResponse;
import com.planfit.server.common.message.SuccessMessage;
import com.planfit.server.service.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RoutineController {

    private final RoutineService routineService;

    @PostMapping("/routine")
    public ResponseEntity<BaseResponse<?>> postRoutine(
            @RequestHeader(name = "user_id") Long userId,
            @RequestParam(name = "exercise_id") Long exerciseId
    ) {
        routineService.createRoutine(userId, exerciseId);

        return ApiResponseUtil.success(
                SuccessMessage.ROUTINE_CREATE_SUCCESS
        );
    }

    @PatchMapping("/exercises/{exerciseId}/like")
    public ResponseEntity<BaseResponse<?>> patchExerciseLike(
            @RequestHeader(name = "user_id") Long userId,
            @PathVariable(name = "exercise_id") Long exerciseId
    ) {

        routineService.patchExerciseLike(userId, exerciseId);

        return ApiResponseUtil.success(
                SuccessMessage.EXERCISE_LIKE_POST_SUCCESS
        );
    }

    @PatchMapping("/exercises/{exerciseId}/unlike")
    public ResponseEntity<BaseResponse<?>> patchExerciseUnLike(
            @RequestHeader(name = "user_id") Long userId,
            @PathVariable(name = "exercise_id") Long exerciseId
    ) {

        routineService.patchExerciseUnLike(userId, exerciseId);

        return ApiResponseUtil.success(
                SuccessMessage.EXERCISE_DELETE_UNLIKE_SUCCESS
        );
    }
}
