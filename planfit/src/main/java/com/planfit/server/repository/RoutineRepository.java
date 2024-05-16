package com.planfit.server.repository;


import com.planfit.server.domain.Exercise;
import com.planfit.server.domain.Routine;
import com.planfit.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
    Optional<Routine> findByUserAndExercise(User user, Exercise exercise);
    List<Routine> findAllByUserOrderBySequenceAsc(User user);
}
