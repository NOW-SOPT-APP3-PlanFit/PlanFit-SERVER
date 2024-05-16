package com.planfit.server.domain;

import com.planfit.server.dto.request.UserPutRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int round;

    private int minute;
    private String condition;

    @OneToMany(mappedBy = "user")
    private List<Routine> routines = new ArrayList<>();

    public void update(UserPutRequest request) {
        minute = request.minute();
        condition = request.condition();
    }
}
