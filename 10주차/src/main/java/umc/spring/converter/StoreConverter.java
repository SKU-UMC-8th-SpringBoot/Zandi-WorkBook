package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StoreConverter {

    public static StoreResponseDTO.JoinResponseDTO toJoinResponseDTO(Store store) {
        return StoreResponseDTO.JoinResponseDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDTO request, Region region) {

        return Store.builder()
                .name(request.getName())
                .score(request.getScore())
                .region(region)
                .address(request.getAddress())
                .reviewList(new ArrayList<>())
                .missionList(new ArrayList<>())
                .build();
    }
}
