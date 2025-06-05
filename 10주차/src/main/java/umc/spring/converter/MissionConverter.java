package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.MissionPreviewDTO missionPreviewDTO(Mission mission){

        return MissionResponseDTO.MissionPreviewDTO.builder()

                .missionSpec(mission.getMission_spec())
                .storeName(mission.getStore().getName())
                .reward(mission.getReward())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .deadline(mission.getDeadline())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewListDTO missionPreviewListDTO(Page<Mission> missionList){

        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(MissionConverter::missionPreviewDTO).collect(Collectors.toList());
        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalElements(missionList.getTotalElements())
                .totalPage(missionList.getTotalPages())
                .listSize(missionPreviewDTOList.size())
                .missionList(missionPreviewDTOList).build();
    }
}
