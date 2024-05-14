package com.planfit.server.dto.request;

import com.planfit.server.domain.Exercise;
import com.planfit.server.domain.Routine;

import java.util.List;

public record ExerciseFindAllDto(

        Long id,
        String name,
        int set,
        int weight,
        int count,
        int index
) {
    public static List<ExerciseFindAllDto> listOf(List<Routine> routines) {
        return routines
                .stream()
                .map(routine -> new ExerciseFindAllDto(
                        routine.getId(),
                        routine.getExercise().getName(),
                        routine.getExercise().getSets().size(),
                        routine.getExercise().getWeight(),
                        routine.getExercise().getTimes(),
                        routine.getSequence()
                )).toList();
    }
}
