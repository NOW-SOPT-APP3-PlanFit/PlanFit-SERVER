package com.planfit.server.service;


import com.planfit.server.common.exception.IndexOutBoundsException;
import com.planfit.server.common.message.ErrorMessage;
import com.planfit.server.domain.Exercise;
import com.planfit.server.domain.Routine;
import com.planfit.server.domain.Set;
import com.planfit.server.domain.User;
import com.planfit.server.repository.SetRepository;
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


    @Transactional
    public void addSet(final Long userId, final Long exerciseId) {
        User user = findUserById(userId);
        Exercise exercise = findExerciseById(exerciseId);

        Routine routine = findRoutine(user, exercise);

        Set.addSet(routine);
    }

    @Transactional
    public void completeSet(final Long userId, final Long exerciseId) {
        User user = findUserById(userId);
        Exercise exercise = findExerciseById(exerciseId);

        Routine routine = findRoutine(user, exercise);

        Set sets = findFirstIncompleteSet(routine.getSets());
        sets.setIsDone();
    }

    public Set findFirstIncompleteSet(List<Set> sets) {
        return sets.stream()
                .filter(set -> !set.isDone())
                .findFirst().orElseThrow(
                        () -> new IndexOutBoundsException(ErrorMessage.SET_OVER_INDEX_REQUEST)
                );
    }

    public User findUserById(Long userId) {
        return userService.getUserById(userId);
    }

    public Exercise findExerciseById(Long exerciseId) {
        return exerciseService.getExerciseById(exerciseId);
    }

    public Routine findRoutine(User user, Exercise exercise) {
        return routineService.getRoutineByUserAndExercise(user, exercise);
    }

}
