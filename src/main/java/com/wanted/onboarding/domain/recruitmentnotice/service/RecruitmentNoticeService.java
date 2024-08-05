package com.wanted.onboarding.domain.recruitmentnotice.service;

import com.wanted.onboarding.domain.recruitmentnotice.dto.RecruitmentNoticeDto;
import com.wanted.onboarding.domain.recruitmentnotice.repository.RecruitmentNoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecruitmentNoticeService {

    private final RecruitmentNoticeRepository noticeRepository;

    public void save(RecruitmentNoticeDto dto){
        // 1. companyId로 company 조회
    }

}
