package com.planfit.server.repository;

import com.planfit.server.domain.Routine;
import com.planfit.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoutineRepository extends JpaRepository<Routine, Long> {

    List<Routine> findAllByUserOrderBySequenceAsc(User user);

    List<Routine> findAllByUserId(Long userId);

    Optional<Routine> findByExerciseIdAndUserId(Long id, Long id1);
}
