package com.wanted.onboarding.domain.recruitmentnotice.controller;

import com.wanted.onboarding.common.response.CommonResponse;
import com.wanted.onboarding.domain.recruitmentnotice.dto.RecruitmentNoticeDto;
import com.wanted.onboarding.domain.recruitmentnotice.service.RecruitmentNoticeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/recruitment-notice")
@RequiredArgsConstructor
@Slf4j
public class RecruitmentNoticeController {

    private final RecruitmentNoticeService noticeService;

    @PostMapping("/save")
    public CommonResponse<Long> save(@Valid @RequestBody RecruitmentNoticeDto dto){
        return CommonResponse.ok("공고가 등록되었습니다.", noticeService.save(dto)) ;
    }
}
