package com.planfit.server.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.planfit.server.common.ApiResponseUtil;
import com.planfit.server.common.BaseResponse;
import com.planfit.server.common.message.SuccessMessage;
import com.planfit.server.domain.Exercise;
import com.planfit.server.service.RoutineService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RoutineController {

    private final RoutineService routineService;

    @PostMapping("/exercise/{exerciseId}/like")
    public ResponseEntity<BaseResponse<?>> postExerciseLike(@RequestHeader Long userId,
                                                            @PathVariable Long exerciseId) {

        routineService.postExerciseLike(userId, exerciseId);

        return ApiResponseUtil.success(SuccessMessage.POST_EXERCISE_LIKE_SUCCESS);
    }

    @DeleteMapping("/exercise/{exerciseId}/unlike")
    public ResponseEntity<BaseResponse<?>> deleteExerciseLike(@RequestHeader Long userId,
                                                              @PathVariable Long exerciseId) {

        routineService.deleteExerciseLike(userId, exerciseId);

        return ApiResponseUtil.success(SuccessMessage.DELETE_EXERCISE_UNLIKE_SUCCESS);

    }
}
