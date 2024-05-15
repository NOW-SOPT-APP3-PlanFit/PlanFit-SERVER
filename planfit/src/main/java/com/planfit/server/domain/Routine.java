package com.planfit.server.domain;

import jakarta.persistence.*;
import lombok.*;

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

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "exercise_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Exercise exercise;

    public void like() {
        this.isLike = true;
    }

    public void unlike() {
        this.isLike = false;
    }
}
