package com.planfit.server.service;

import com.planfit.server.domain.User;
import com.planfit.server.dto.response.ExerciseGetAllResponse;
import com.planfit.server.repository.RoutineRepository;
import com.planfit.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final UserRepository userRepository;
    private final RoutineRepository routineRepository;

    @Transactional(readOnly = true)
    //운동 리스트 조회
    public ExerciseGetAllResponse findExercises(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();

        return ExerciseGetAllResponse.fromRoutines(routineRepository.findAllByUserOrderBySequenceAsc(user));
    }
}
