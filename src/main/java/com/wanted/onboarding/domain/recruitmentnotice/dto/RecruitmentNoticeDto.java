package com.wanted.onboarding.domain.recruitmentnotice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentNoticeDto {

    private int companyId;

    private String position;

    private int compensation;

    private String content;

    private String languageUsed;


}
