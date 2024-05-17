package com.planfit.server.service;

import com.planfit.server.common.exception.NotFoundException;
import com.planfit.server.common.message.ErrorMessage;
import com.planfit.server.domain.Exercise;
import com.planfit.server.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public Exercise getExerciseById(Long exerciseId) {
        return exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.EXERCISE_NOT_FOUND));
    }
}