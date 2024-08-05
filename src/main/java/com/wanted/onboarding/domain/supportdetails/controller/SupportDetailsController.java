package com.wanted.onboarding.domain.supportdetails.controller;

import com.wanted.onboarding.common.response.CommonResponse;
import com.wanted.onboarding.domain.supportdetails.dto.save.SupportReponsetDto;
import com.wanted.onboarding.domain.supportdetails.dto.save.SupportRequestDto;
import com.wanted.onboarding.domain.supportdetails.service.SupportDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/support-details")
@RequiredArgsConstructor
@Slf4j
public class SupportDetailsController {

    private final SupportDetailsService supportService;

    @PostMapping()
    public CommonResponse<SupportReponsetDto> applyForNotice(@Valid @RequestBody SupportRequestDto dto){
        return CommonResponse.ok("지원이 완료되었습니다.",supportService.applyForNotice(dto));

    }

}
