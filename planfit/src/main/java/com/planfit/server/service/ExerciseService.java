package com.planfit.server.service;

import com.planfit.server.common.exception.NotFoundException;
import com.planfit.server.common.message.ErrorMessage;
import com.planfit.server.domain.Exercise;
import com.planfit.server.domain.Routine;
import com.planfit.server.domain.User;
import com.planfit.server.dto.request.ExerciseReorderRequest;
import com.planfit.server.dto.response.ExerciseGetAllResponse;
import com.planfit.server.repository.ExerciseRepository;
import com.planfit.server.repository.RoutineRepository;
import com.planfit.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExerciseService {

    private final UserRepository userRepository;
    private final RoutineRepository routineRepository;
    private final ExerciseRepository exerciseRepository;

    //운동 리스트 조회
    public ExerciseGetAllResponse findExercises(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();

        return ExerciseGetAllResponse.fromRoutines(routineRepository.findAllByUserOrderBySequenceAsc(user));
    }

    @Transactional
    //운동 리스트 순서 변경
    public void reorderExercises(Long userId, List<ExerciseReorderRequest> exercises) {
        User user = userRepository.findById(userId).orElseThrow();

        for (ExerciseReorderRequest exercise : exercises) {
            getExercise(exercise.id());
        }

        //모든 운동의 sequence를 임시값으로 초기화
        List<Routine> routines = routineRepository.findAllByUserId(userId);
        int tempSequence = -1000;
        for (Routine routine : routines) {
            routine.setTemporarySequence(tempSequence--);
        }
        routineRepository.saveAll(routines);

        //새로운 순서로 업데이트
        for (ExerciseReorderRequest exercise : exercises) {
            Routine routine = routineRepository.findByExerciseIdAndUserId(exercise.id(), user.getId())
                    .orElseThrow(() -> new NotFoundException(ErrorMessage.ROUTINE_NOT_FOUND));
            routine.updateSequence(exercise.index());
            routineRepository.save(routine);
        }

    }

    public Exercise getExercise(Long exerciseId) {
        return exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.EXERCISE_NOT_FOUND));
    }
}
