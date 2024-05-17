package com.planfit.server.controller;

import com.planfit.server.common.ApiResponseUtil;
import com.planfit.server.common.BaseResponse;
import com.planfit.server.common.message.SuccessMessage;
import com.planfit.server.dto.request.ExerciseReorderAllRequest;
import com.planfit.server.service.RoutineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.path}")
public class ExerciseController {

    private final RoutineService routineService;

    //운동 리스트 조회
    @GetMapping("/exercises")
    public ResponseEntity<BaseResponse<?>> exercisesList(@RequestHeader Long userId) {

        return ApiResponseUtil.success(SuccessMessage.EXERCISES_FIND_SUCCESS, routineService.findRoutines(userId));
    }

    //운동 리스트 순서 변경
    @PutMapping("/exercises")
    public ResponseEntity<BaseResponse<?>> exercisesReorder(@RequestHeader Long userId,
                                                            @Valid @RequestBody ExerciseReorderAllRequest exercises) {
        routineService.reorderExercises(userId, exercises.exercises());
        return ApiResponseUtil.success(SuccessMessage.EXERCISES_REORDER_SUCCESS);
    }

}
