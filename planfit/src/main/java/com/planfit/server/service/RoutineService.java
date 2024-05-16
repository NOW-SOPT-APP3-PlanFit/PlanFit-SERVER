package com.planfit.server.service;

import com.planfit.server.common.exception.NotFoundException;
import com.planfit.server.common.message.ErrorMessage;
import com.planfit.server.domain.Exercise;
import com.planfit.server.domain.Routine;
import com.planfit.server.domain.Set;
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

    private final UserService userService;
    private final ExerciseService exerciseService;

    @Transactional
    public Routine createRoutine(Long userId, Long exerciseId) {
        User user = getUserById(userId);
        Exercise exercise = getExerciseById(exerciseId);

        checkRoutineExist(user, exercise);

        int sequence = getNextSequence();

        Routine routine = Routine.create(user, exercise, sequence);

        return routineRepository.save(routine);
    }

    private void checkRoutineExist(User user, Exercise exercise) {
        if (routineRepository.existsByUserAndExercise(user, exercise)) {
            throw new NotFoundException(ErrorMessage.ROUTINE_ALREADY_EXIST);
        } else {
            return;
        }
    }

    private int getNextSequence() {
        return routineRepository.findMaxSequence().orElse(0) + 1;
    }

    @Transactional
    public void postExerciseLike(Long userId, Long exerciseId) {
        User user = getUserById(userId);
        Exercise exercise = getExerciseById(exerciseId);

        Routine routine = getRoutineByUserAndExercise(user, exercise);
        routine.like();
    }

    @Transactional
    public void deleteExerciseLike(Long userId, Long exerciseId) {
        User user = getUserById(userId);
        Exercise exercise = getExerciseById(exerciseId);

        Routine routine = getRoutineByUserAndExercise(user, exercise);
        routine.unlike();
    }

    public User getUserById(Long userId) {
        return userService.getUserById(userId);
    }

    public Exercise getExerciseById(Long exerciseId) {
        return exerciseService.getExerciseById(exerciseId);
    }

    public Routine getRoutineByUserAndExercise(User user, Exercise exercise) {
        return routineRepository.findByUserAndExercise(user, exercise).orElseThrow(
                () -> new NotFoundException(ErrorMessage.ROUTINE_NOT_FOUND)
        );
    }

}
