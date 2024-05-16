package com.planfit.server.service;


import com.planfit.server.domain.Exercise;
import com.planfit.server.domain.Routine;
import com.planfit.server.repository.ExerciseRepository;
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

    SetRepository setRepository;
    ExerciseService exerciseService;

    @PostConstruct
    public void initializeBasicSet() {
        List<Exercise> exercisesList = getAllExercises();
        for (Exercise exercise : exercisesList) {
            List<Routine> routines = exercise.getRoutines();
            for (Routine routine : routines) {

            }
        }

    }

    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }




}
