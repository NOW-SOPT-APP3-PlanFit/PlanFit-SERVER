package com.planfit.server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "sets")
@Entity
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isDone;

    @JoinColumn(name = "routine_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Routine routine;

    public static List<Set> createSets(Routine routine) {
        List<Set> sets = new ArrayList<>();

        IntStream.range(0, 4).forEach(i ->
                sets.add(Set.builder()
                        .routine(routine)
                        .build()
                )
        );
        return sets;
    }

    public static void addSet(Routine routine) {
        Set set = Set.builder().routine(routine).isDone(false).build();
        routine.getSets().add(set);
    }

    public void setIsDone() {
        this.isDone = true;
    }
}