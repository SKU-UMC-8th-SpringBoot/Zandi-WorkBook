package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistMission;

public class MemberMissionRequestDTO {

    @Getter
    public static class JoinMMDTO {

        @NotNull
        Integer missionStatus;

        @ExistMember
        @NotNull
        Long memberId;

        @ExistMission
        @NotNull
        Long missionId;

    }
}
