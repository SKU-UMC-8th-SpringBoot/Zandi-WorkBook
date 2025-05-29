package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.JoinMissionResponseDTO toJoinMissionResponseDTO(Mission mission) {
        return MissionResponseDTO.JoinMissionResponseDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.JoinMissionRequestDTO request, Store store) {
        return Mission.builder()
                .reward(request.getReward())
                .mission_spec(request.getMissionSpec())
                .deadline(request.getDeadline())
                .store(store)
                .build();
    }
}
