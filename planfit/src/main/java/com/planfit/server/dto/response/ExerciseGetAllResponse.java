package com.planfit.server.dto.response;

import com.planfit.server.domain.Routine;

import java.util.List;

public record ExerciseGetAllResponse(

        List<ExerciseGetResponse> exercises
) {
    public static ExerciseGetAllResponse fromRoutines(List<Routine> routines) {
        return new ExerciseGetAllResponse(ExerciseGetResponse.listOf(routines));
    }
}
