package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStores;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class JoinReivewDto {
        @NotBlank
        private String body;
        @NotNull
        private Float score;
        @NotNull
        private Long memberId;
        @NotNull
        @ExistStores
        private Long storeId;
        private List<Long> imageList;
    }


}
