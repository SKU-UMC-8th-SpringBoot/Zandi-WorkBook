package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.JoinMemberMissionResponseDTO toJoinResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.JoinMemberMissionResponseDTO.builder()
                .MemberMissionId(memberMission.getId())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.JoinMMDTO request, Member member, Mission mission) {

        MissionStatus missionStatus = null;

        switch (request.getMissionStatus()){
            case 1:
                missionStatus = MissionStatus.CHALLENGING;
                break;
            case 2:
                missionStatus = MissionStatus.COMPLETE;
                break;
        }

        return MemberMission.builder()
                .mission(mission)
                .member(member)
                .missionStatus(missionStatus)
                .build();
    }
}
