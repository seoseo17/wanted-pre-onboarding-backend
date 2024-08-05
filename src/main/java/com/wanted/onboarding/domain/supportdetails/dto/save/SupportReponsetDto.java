package com.wanted.onboarding.domain.supportdetails.dto.save;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wanted.onboarding.entity.RecruitmentNotice;
import com.wanted.onboarding.entity.SupportDetails;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Setter
public class SupportReponsetDto {

    private Long supportId;

    private String companyName;

    private String companyNation;

    private String companyRegion;

    private String position;

    private int compensation;

    private String content;

    private String languageUsed;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public SupportReponsetDto(SupportDetails detail){
        this.supportId = detail.getId();
        this.companyName = detail.getRecruitmentNotice().getCompany().getName();
        this.companyNation =  detail.getRecruitmentNotice().getCompany().getNation();
        this.companyRegion =  detail.getRecruitmentNotice().getCompany().getRegion();
        this.position = detail.getRecruitmentNotice().getPosition();
        this.compensation = detail.getRecruitmentNotice().getCompensation();
        this.content = detail.getRecruitmentNotice().getContent();
        this.languageUsed = detail.getRecruitmentNotice().getLanguageUsed();
        this.createdAt = detail.getCreatedAt();
    }
}
