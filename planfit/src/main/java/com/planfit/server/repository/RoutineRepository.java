package com.planfit.server.repository;

import com.planfit.server.domain.Exercise;
import com.planfit.server.domain.Routine;
import com.planfit.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;
import java.util.Optional;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
    Optional<Routine> findByUserAndExercise(User user, Exercise exercise);
    List<Routine> findAllByUserOrderBySequenceAsc(User user);

    @Query("SELECT MAX(r.sequence) FROM Routine r")
    Optional<Integer> findMaxSequence();

    boolean existsByUserAndExercise(User user, Exercise exercise);

    List<Routine> findAllByUserId(Long userId);

    Optional<Routine> findByExerciseAndUser(Exercise exercise1, User user);
}
