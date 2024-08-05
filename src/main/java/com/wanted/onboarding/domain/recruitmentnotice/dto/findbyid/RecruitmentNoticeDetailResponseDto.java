package com.wanted.onboarding.domain.recruitmentnotice.dto.findbyid;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.wanted.onboarding.entity.RecruitmentNotice;
import lombok.*;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Setter
public class RecruitmentNoticeDetailResponseDto {

    private Long noticeId;

    private String companyName;

    private String companyNation;

    private String companyRegion;

    private String position;

    private int compensation;

    private String content;

    private String languageUsed;

    private List<Long> noticeList;

    public RecruitmentNoticeDetailResponseDto(RecruitmentNotice notice, List<Long> notices){
        this.noticeId = notice.getId();
        this.companyName = notice.getCompany().getName();
        this.companyNation = notice.getCompany().getNation();
        this.companyRegion = notice.getCompany().getRegion();
        this.position = notice.getPosition();
        this.compensation = notice.getCompensation();
        this.content = notice.getContent();
        this.languageUsed = notice.getLanguageUsed();
        this.noticeList = notices;
    }
}
