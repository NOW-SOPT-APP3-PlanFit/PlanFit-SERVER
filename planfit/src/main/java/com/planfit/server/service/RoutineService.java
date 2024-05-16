package com.planfit.server.service;

import com.planfit.server.domain.Exercise;
import com.planfit.server.domain.Routine;
import com.planfit.server.domain.User;
import com.planfit.server.repository.ExerciseRepository;
import com.planfit.server.repository.RoutineRepository;
import com.planfit.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RoutineService {

    private final RoutineRepository routineRepository;
    private final UserRepository userRepository;
    private final ExerciseRepository exerciseRepository;


    @Transactional
    public void postExerciseLike(Long userId, Long exerciseId) {
        User user = userRepository.findById(userId).orElseThrow();
        Exercise exercise = exerciseRepository.findById(exerciseId).orElseThrow();

        Routine routine = getRoutine(user, exercise);
        routine.like();
        routineRepository.save(routine);
    }

    public Routine getRoutine(User user, Exercise exercise) {
        return routineRepository.findByUserAndExercise(user, exercise).orElseThrow();
    }

    @Transactional
    public void deleteExerciseLike(Long userId, Long exerciseId) {
        User user = userRepository.findById(userId).orElseThrow();
        Exercise exercise = exerciseRepository.findById(exerciseId).orElseThrow();

        Routine routine = getRoutine(user, exercise);
        routine.unlike();
        routineRepository.save(routine);
    }
}
