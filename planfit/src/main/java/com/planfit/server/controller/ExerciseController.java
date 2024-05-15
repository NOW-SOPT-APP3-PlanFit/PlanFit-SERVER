package com.planfit.server.controller;

import com.planfit.server.common.ApiResponseUtil;
import com.planfit.server.common.BaseResponse;
import com.planfit.server.common.message.SuccessMessage;
import com.planfit.server.dto.request.ExerciseReorderAllRequest;
import com.planfit.server.dto.request.ExerciseReorderRequest;
import com.planfit.server.service.ExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //운동 리스트 순서 변경
    @PutMapping("/exercises")
    public ResponseEntity<BaseResponse<?>> exercisesReorder(@RequestHeader Long userId,
                                                            @Valid @RequestBody ExerciseReorderAllRequest exercises) {
        exerciseService.reorderExercises(userId, exercises.exercises());
        return ApiResponseUtil.success(SuccessMessage.EXERCISES_REORDER_SUCCESS);
    }

}
