package com.wanted.onboarding.domain.recruitmentnotice.service;

import com.wanted.onboarding.domain.company.service.CompanyService;
import com.wanted.onboarding.domain.recruitmentnotice.dto.RecruitmentNoticeDto;
import com.wanted.onboarding.domain.recruitmentnotice.repository.RecruitmentNoticeRepository;
import com.wanted.onboarding.entity.Company;
import com.wanted.onboarding.entity.RecruitmentNotice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecruitmentNoticeService {

    private final RecruitmentNoticeRepository noticeRepository;

    private final CompanyService companyService;

    public Long save(RecruitmentNoticeDto dto){
        // 1. companyId로 company 조회
        Company company = companyService.findById(dto.getCompanyId());

        RecruitmentNotice notice = noticeRepository.save(dto.toEntity(company));
        return notice.getId();
    }

}
