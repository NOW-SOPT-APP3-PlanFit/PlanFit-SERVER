package com.planfit.server.service;

import com.planfit.server.common.exception.NotFoundException;
import com.planfit.server.common.message.ErrorMessage;
import com.planfit.server.domain.Exercise;
import com.planfit.server.domain.Routine;
import com.planfit.server.domain.User;
import com.planfit.server.dto.request.ExerciseReorderRequest;
import com.planfit.server.dto.response.ExerciseGetAllResponse;
import com.planfit.server.repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RoutineService {

    private final RoutineRepository routineRepository;
    private final UserService userService;
    private final ExerciseService exerciseService;

    @Transactional
    public Routine createRoutine(Long userId, Long exerciseId) {
        User user = userService.getUserById(userId);
        Exercise exercise = exerciseService.getExerciseById(exerciseId);

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
    public void patchExerciseLike(Long userId, Long exerciseId) {
        User user = userService.getUserById(userId);
        Exercise exercise = exerciseService.getExerciseById(exerciseId);

        Routine routine = getRoutineByUserAndExercise(user, exercise);
        routine.like();
    }

    @Transactional
    public void patchExerciseUnLike(Long userId, Long exerciseId) {
        User user = userService.getUserById(userId);
        Exercise exercise = exerciseService.getExerciseById(exerciseId);

        Routine routine = getRoutineByUserAndExercise(user, exercise);
        routine.unlike();
    }

    public Routine getRoutineByUserAndExercise(User user, Exercise exercise) {
        return routineRepository.findByUserAndExercise(user, exercise).orElseThrow(
                () -> new NotFoundException(ErrorMessage.ROUTINE_NOT_FOUND)
        );
    }

    //운동 리스트 조회
    public ExerciseGetAllResponse findRoutines(Long userId) {
        User user = userService.getUserById(userId);

        return ExerciseGetAllResponse.fromRoutines(routineRepository.findAllByUserOrderBySequenceAsc(user));
    }

    @Transactional
    //운동 리스트 순서 변경
    public void reorderExercises(Long userId, List<ExerciseReorderRequest> exercises) {
        User user = userService.getUserById(userId);

        //새로운 순서로 업데이트
        updateRoutinesWithNewOrder(exercises, user);
    }

    private void updateRoutinesWithNewOrder(List<ExerciseReorderRequest> exercises, User user) {
        exercises.stream().forEach(request -> {
            Exercise exercise = exerciseService.getExerciseById(request.id());
            Routine routine = getRoutineByUserAndExercise(user, exercise);
            routine.updateSequence(request.index());
        });
    }

}
