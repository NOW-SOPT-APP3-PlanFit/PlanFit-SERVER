package com.planfit.server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isLike;

    @Column(name = "seq")
    private int sequence;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "exercise_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Exercise exercise;

    @OneToMany(mappedBy = "routine")
    private List<Set> sets = new ArrayList<>();
  
      public void updateSequence(int sequence) {
        this.sequence = sequence;
    }
}

    public void like() {
        this.isLike = true;
    }

    public void unlike() {
        this.isLike = false;
    }
}

