package com.wanted.onboarding.domain.recruitmentnotice.controller;

import com.wanted.onboarding.common.response.CommonResponse;
import com.wanted.onboarding.domain.recruitmentnotice.dto.save.RecruitmentNoticeDto;
import com.wanted.onboarding.domain.recruitmentnotice.dto.update.RecruitmentNoticeUpdateDto;
import com.wanted.onboarding.domain.recruitmentnotice.service.RecruitmentNoticeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/recruitment-notice")
@RequiredArgsConstructor
@Slf4j
public class RecruitmentNoticeController {

    private final RecruitmentNoticeService noticeService;

    @PostMapping
    public CommonResponse<Long> save(@Valid @RequestBody RecruitmentNoticeDto dto){
        return CommonResponse.ok("공고가 등록되었습니다.", noticeService.save(dto)) ;
    }

    @PutMapping("/{id}")
    public CommonResponse<Long> update(@PathVariable Long id,
                                       @Valid @RequestBody RecruitmentNoticeUpdateDto dto){

        return CommonResponse.ok("공고가 수정되었습니다.", noticeService.update(id,dto)) ;
    }
    @DeleteMapping("/{id}")
    public CommonResponse<?> delete(@PathVariable Long id){
        noticeService.delete(id);
        return CommonResponse.ok("공고가 삭제되었습니다.");
    }
}
