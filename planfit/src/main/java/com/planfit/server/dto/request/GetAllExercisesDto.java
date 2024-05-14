package com.planfit.server.dto.request;

import com.planfit.server.domain.Routine;

import java.util.List;

public record GetAllExercisesDto(

        Long id,
        String name,
        int set,
        int weight,
        int count,
        int index
) {
    public static List<GetAllExercisesDto> listOf(List<Routine> routines) {
        return routines
                .stream()
                .map(routine -> new GetAllExercisesDto(
                        routine.getId(),
                        routine.getExercise().getName(),
                        routine.getExercise().getSets().size(),
                        routine.getExercise().getWeight(),
                        routine.getExercise().getTimes(),
                        routine.getSequence()
                )).toList();
    }
}
