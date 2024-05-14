package com.planfit.server.dto.response;

import com.planfit.server.domain.Routine;

import java.util.List;

public record ExerciseGetAllResponse(

        Long id,
        String name,
        int set,
        int weight,
        int count,
        int index
) {
    public static List<ExerciseGetAllResponse> listOf(List<Routine> routines) {
        return routines
                .stream()
                .map(routine -> new ExerciseGetAllResponse(
                        routine.getId(),
                        routine.getExercise().getName(),
                        routine.getExercise().getSets().size(),
                        routine.getExercise().getWeight(),
                        routine.getExercise().getTimes(),
                        routine.getSequence()
                )).toList();
    }
}
