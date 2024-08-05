package com.wanted.onboarding.domain.supportdetails.service;

import com.wanted.onboarding.common.exception.CustomException;
import com.wanted.onboarding.domain.recruitmentnotice.service.RecruitmentNoticeService;
import com.wanted.onboarding.domain.supportdetails.dto.save.SupportReponsetDto;
import com.wanted.onboarding.domain.supportdetails.dto.save.SupportRequestDto;
import com.wanted.onboarding.domain.supportdetails.repository.SupportDetailsRepository;
import com.wanted.onboarding.domain.user.service.UserService;
import com.wanted.onboarding.entity.RecruitmentNotice;
import com.wanted.onboarding.entity.SupportDetails;
import com.wanted.onboarding.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.wanted.onboarding.common.response.ErrorCode.DUPLICATE_SUPPORT;

@Service
@RequiredArgsConstructor
@Slf4j
public class SupportDetailsService {

    private final SupportDetailsRepository supportRepository;
    private final UserService userService;
    private final RecruitmentNoticeService noticeService;


    public SupportReponsetDto applyForNotice(SupportRequestDto dto){
        //1. user, 채용공고 조회
        User user = userService.findById(dto.getUserId());
        RecruitmentNotice notice =noticeService.findById(dto.getNoticeId());

        //2. 중복 지원 확인
        if (supportRepository.existsByUserIdAndRecruitmentNoticeId(dto.getUserId(), dto.getNoticeId())){
            throw new CustomException(DUPLICATE_SUPPORT);
        }

        //3. 지원 내역 저장
        SupportDetails support = SupportDetails.builder()
                .user(user)
                .recruitmentNotice(notice)
                .build();

        SupportDetails detail = supportRepository.save(support);
        return new SupportReponsetDto(detail);
    }
}
