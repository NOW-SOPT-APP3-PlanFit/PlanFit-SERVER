package com.planfit.server.dto.request;

import jakarta.validation.Valid;

import java.util.List;

public record ExerciseReorderAllRequest(

        @Valid List<ExerciseReorderRequest> exercises
) {
}
