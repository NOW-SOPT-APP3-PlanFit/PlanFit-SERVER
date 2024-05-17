package com.planfit.server.controller;


import com.planfit.server.common.ApiResponseUtil;
import com.planfit.server.common.BaseResponse;
import com.planfit.server.common.message.SuccessMessage;
import com.planfit.server.domain.Exercise;
import com.planfit.server.domain.Routine;
import com.planfit.server.domain.Set;
import com.planfit.server.domain.User;
import com.planfit.server.service.ExerciseService;
import com.planfit.server.service.RoutineService;
import com.planfit.server.service.SetService;
import com.planfit.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.path}")
public class SetController {

    private final SetService setService;

    @PostMapping("/exercises/{exerciseId}/set")
    public ResponseEntity<BaseResponse<?>> postAddSet(
            @RequestHeader(name = "user_id") final Long userId,
            @PathVariable(name = "exercise_id") final Long exerciseId
    ) {
        setService.addSet(userId, exerciseId);

        return ApiResponseUtil.success(
                SuccessMessage.SET_ADD_SET_SUCCESS
        );

    }

    @PutMapping("/exercises/{exerciseId}/set")
    public ResponseEntity<BaseResponse<?>> putSetIsDone(
            @RequestHeader(name = "user_id") final Long userId,
            @PathVariable(name = "exercise_id") final Long exerciseId
    ) {
        setService.completeSet(userId, exerciseId);

        return ApiResponseUtil.success(
                SuccessMessage.SET_COMPLETE_SET_SUCCESS
        );
    }
}
