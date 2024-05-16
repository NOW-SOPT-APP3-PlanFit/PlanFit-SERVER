package com.planfit.server.dto.response;

import com.planfit.server.domain.Routine;

import java.util.List;

public record ExerciseGetResponse(

        Long id,
        String name,
        int set,
        int weight,
        int count,
        int index
) {
    public static List<ExerciseGetResponse> listOf(List<Routine> routines) {
        return routines
                .stream()
                .map(routine -> new ExerciseGetResponse(
                        routine.getId(),
                        routine.getExercise().getName(),
                        routine.getExercise().getSets().size(),
                        routine.getExercise().getWeight(),
                        routine.getExercise().getTimes(),
                        routine.getSequence()
                )).toList();
    }
}
