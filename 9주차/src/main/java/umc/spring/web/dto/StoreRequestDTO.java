package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.Region;
import umc.spring.validation.annotation.ExistRegions;

import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class JoinDTO{

        @NotBlank
        String name;
        @NotBlank
        String address;
        @NotNull
        Float score;
        @NotNull
        @ExistRegions
        Long regionId;

        List<Long> missionList;

        List<Long> reviewList;

    }
}

