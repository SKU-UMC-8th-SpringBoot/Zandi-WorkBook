package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStores;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class JoinMissionRequestDTO {
        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotBlank
        String missionSpec;
        @NotNull
        Integer missionStatus;

        @NotNull
        @ExistStores
        Long storeId;

    }
}
