package com.wanted.onboarding.domain.supportdetails.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupportRequestDto {

    @NotNull(message = "채용공고 ID는 필수 값입니다.")
    private Long notidId;

    @NotNull(message = "사용자 ID는 필수 값입니다.")
    private Long userId;
}
