package com.planfit.server.service;


import com.planfit.server.domain.Exercise;
import com.planfit.server.domain.Routine;
import com.planfit.server.domain.Set;
import com.planfit.server.domain.User;
import com.planfit.server.repository.ExerciseRepository;
import com.planfit.server.repository.RoutineRepository;
import com.planfit.server.repository.SetRepository;
import jakarta.annotation.PostConstruct;
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
        User user = userService.getUserById(userId);
        Exercise exercise = exerciseService.getExerciseById(exerciseId);

        Routine routine = routineService.getRoutine(user, exercise);

        Set.addSet(routine);
    }
}
