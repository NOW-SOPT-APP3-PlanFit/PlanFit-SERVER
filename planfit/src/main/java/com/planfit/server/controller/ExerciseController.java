package com.planfit.server.controller;

import com.planfit.server.common.ApiResponseUtil;
import com.planfit.server.common.BaseResponse;
import com.planfit.server.common.message.SuccessMessage;
import com.planfit.server.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.path}")
public class ExerciseController {

    private final ExerciseService exerciseService;

    //운동 리스트 조회
    @GetMapping("/exercises")
    public ResponseEntity<BaseResponse<?>> exercisesList(@RequestHeader Long userId) {

        return ApiResponseUtil.success(SuccessMessage.EXERCISES_FIND_SUCCESS, exerciseService.findExercises(userId));
    }
}
