package com.planfit.server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.planfit.server.common.Constant.DEFAULT_SET_COUNT;

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

        IntStream.range(0, DEFAULT_SET_COUNT).forEach(i ->
                sets.add(makeSet(routine))
        );
        return sets;
    }

    public static void setDefaultSets(Routine routine) {
        Set set = makeSet(routine);

        routine.getSets().add(set);
    }

    private static Set makeSet(Routine routine) {
        return Set
                .builder()
                .routine(routine)
                .isDone(false)
                .build();
    }

    public void setIsDone() {
        this.isDone = true;
    }
}