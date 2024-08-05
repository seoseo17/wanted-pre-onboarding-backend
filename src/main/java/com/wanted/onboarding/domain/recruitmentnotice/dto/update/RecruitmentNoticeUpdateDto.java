package com.wanted.onboarding.domain.recruitmentnotice.dto.update;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentNoticeUpdateDto {

    @NotEmpty(message = "채용포지션은 필수 값입니다.")
    private String position;

    @NotNull(message = "채용보상금은 필수 값입니다.")
    @Min(value = 0, message = "양수만 입력 가능합니다.")
    private int compensation;

    @NotEmpty(message = "채용내용은 필수 값입니다.")
    private String content;

    @NotEmpty(message = "사용기술은 필수 값입니다.")
    private String languageUsed;
}
