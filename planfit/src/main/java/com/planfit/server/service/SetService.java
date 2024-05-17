package com.planfit.server.service;


import com.planfit.server.common.exception.IndexOutOfBoundsException;
import com.planfit.server.common.message.ErrorMessage;
import com.planfit.server.domain.Exercise;
import com.planfit.server.domain.Routine;
import com.planfit.server.domain.Set;
import com.planfit.server.domain.User;
import com.planfit.server.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SetService {

    private final ExerciseService exerciseService;
    private final UserService userService;
    private final RoutineService routineService;
    private final ExerciseRepository exerciseRepository;


    @Transactional
    public void addSet(final Long userId, final Long exerciseId) {
        User user = userService.getUserById(userId);
        Exercise exercise = exerciseService.getExerciseById(exerciseId);

        Routine routine = routineService.getRoutineByUserAndExercise(user, exercise);

        Set.setDefaultSets(routine);
    }

    @Transactional
    public void completeSet(final Long userId, final Long exerciseId) {
        User user = userService.getUserById(userId);
        Exercise exercise = exerciseService.getExerciseById(exerciseId);

        Routine routine = routineService.getRoutineByUserAndExercise(user, exercise);

        Set sets = findFirstIncompleteSet(routine.getSets());
        sets.setIsDone();
    }

    public Set findFirstIncompleteSet(List<Set> sets) {
        return sets.stream()
                .filter(set -> !set.isDone())
                .findFirst().orElseThrow(
                        () -> new IndexOutOfBoundsException(ErrorMessage.SET_OVER_INDEX_REQUEST)
                );
    }
}
