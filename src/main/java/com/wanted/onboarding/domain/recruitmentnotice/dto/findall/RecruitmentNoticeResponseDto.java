package com.wanted.onboarding.domain.recruitmentnotice.dto.findall;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.wanted.onboarding.entity.RecruitmentNotice;
import lombok.*;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Setter
public class RecruitmentNoticeResponseDto {

    private Long noticeId;

    private String companyName;

    private String companyNation;

    private String companyRegion;

    private String position;

    private int compensation;

    private String languageUsed;

    public RecruitmentNoticeResponseDto(RecruitmentNotice notice){
        this.noticeId = notice.getId();
        this.companyName = notice.getCompany().getName();
        this.companyNation = notice.getCompany().getNation();
        this.companyRegion = notice.getCompany().getRegion();
        this.position = notice.getPosition();
        this.compensation = notice.getCompensation();
        this.languageUsed = notice.getLanguageUsed();
    }

}
