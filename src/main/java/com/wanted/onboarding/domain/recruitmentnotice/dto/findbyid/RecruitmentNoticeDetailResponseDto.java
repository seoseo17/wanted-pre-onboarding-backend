package com.wanted.onboarding.domain.recruitmentnotice.dto.findbyid;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentNoticeResponseDto {

    private Long noticeId;

    private String companyName;

    private String companyNation;

    private String companyRegion;

    private String position;

    private int compensation;

    private String content;

    private String languageUsed;

    private List<Long> noticeList;
}
