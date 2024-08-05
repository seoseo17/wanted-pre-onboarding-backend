package com.wanted.onboarding.domain.recruitmentnotice.service;

import com.wanted.onboarding.common.exception.CustomException;
import com.wanted.onboarding.domain.company.service.CompanyService;
import com.wanted.onboarding.domain.recruitmentnotice.dto.save.RecruitmentNoticeDto;
import com.wanted.onboarding.domain.recruitmentnotice.dto.update.RecruitmentNoticeUpdateDto;
import com.wanted.onboarding.domain.recruitmentnotice.repository.RecruitmentNoticeRepository;
import com.wanted.onboarding.entity.Company;
import com.wanted.onboarding.entity.RecruitmentNotice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.wanted.onboarding.common.response.ErrorCode.RECRUITMENTNOTICE_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecruitmentNoticeService {

    private final RecruitmentNoticeRepository noticeRepository;

    private final CompanyService companyService;

    public RecruitmentNotice findById(Long id){
        return noticeRepository.findById(id).orElseThrow(()-> new CustomException(RECRUITMENTNOTICE_NOT_FOUND));
    }


    public Long save(RecruitmentNoticeDto dto){
        // 1. companyId로 company 조회
        Company company = companyService.findById(dto.getCompanyId());

        RecruitmentNotice notice = noticeRepository.save(dto.toEntity(company));
        return notice.getId();
    }
    @Transactional
    public Long update(Long noticeId, RecruitmentNoticeUpdateDto dto){
        // 1. noticeId로 채용공고 조회
        RecruitmentNotice notice = findById(noticeId);
        notice.update(dto);
        return notice.getId();
    }

}
