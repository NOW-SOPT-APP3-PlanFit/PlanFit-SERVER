package com.planfit.server.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ExerciseReorderRequest(

        @NotNull(message = "운동 ID는 필수 입력 사항입니다.")
        Long id,

        @Min(value = 0, message = "인덱스는 음수가 될 수 없습니다.")
        int index
) {
}
