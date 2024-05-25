package com.planfit.server.controller;

import com.planfit.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RequiredArgsConstructor
@RestController
public class ProfileController {

    private final Environment environment;
    private static final String NULL = "";

    @GetMapping("/profile")
    public String getProfile() {
        return Arrays.stream(environment.getActiveProfiles())
                .findFirst()
                .orElse(NULL);
    }
}
