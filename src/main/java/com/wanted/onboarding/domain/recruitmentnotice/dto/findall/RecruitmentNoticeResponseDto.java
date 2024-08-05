package com.wanted.onboarding.domain.recruitmentnotice.dto.findall;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentNoticeListResponseDto {

    private Long noticeId;

    private String companyName;

    private String companyNation;

    private String companyRegion;

    private String position;

    private int compensation;

    private String languageUsed;

}
