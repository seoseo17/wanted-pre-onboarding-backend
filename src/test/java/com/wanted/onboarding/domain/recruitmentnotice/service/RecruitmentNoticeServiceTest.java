package com.wanted.onboarding.domain.recruitmentnotice.service;

import com.wanted.onboarding.domain.recruitmentnotice.dto.findall.RecruitmentNoticeResponseDto;
import com.wanted.onboarding.domain.recruitmentnotice.dto.save.RecruitmentNoticeDto;
import com.wanted.onboarding.domain.recruitmentnotice.repository.RecruitmentNoticeRepository;
import com.wanted.onboarding.domain.recruitmentnotice.service.RecruitmentNoticeService;
import com.wanted.onboarding.entity.Company;
import com.wanted.onboarding.entity.RecruitmentNotice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class RecruitmentNoticeServiceTest {

    @Autowired
    RecruitmentNoticeService noticeService;

    @Autowired
    RecruitmentNoticeRepository noticeRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    @DisplayName("공고 등록 테스트")
    void save(){
        RecruitmentNoticeDto dto = RecruitmentNoticeDto.builder()
                .companyId(1L)
                .position("백엔드")
                .compensation(5000)
                .content("주니어 백엔드 채용합니다.")
                .languageUsed("Java")
                .build();

        Long noticeId = noticeService.save(dto);

        RecruitmentNotice notice = noticeRepository.findById(noticeId).orElseThrow();

        Assertions.assertThat(notice.getContent()).isEqualTo("주니어 백엔드 채용합니다.");
        //Assertions.assertThat(notice.getContent()).isEqualTo("주니어 백엔드 채용합니다.!!");
    }
    @Transactional
    @Test
    @DisplayName("채용 공고 검색 테스트")
    void search(){
        //given
        RecruitmentNoticeDto dto1 = RecruitmentNoticeDto.builder()
                .companyId(1L)
                .position("백엔드")
                .compensation(5000)
                .content("주니어 백엔드 채용합니다.")
                .languageUsed("Java")
                .build();

        RecruitmentNoticeDto dto2 = RecruitmentNoticeDto.builder()
                .companyId(2L)
                .position("프론트엔드")
                .compensation(5000)
                .content("시니어 프론트엔드 채용합니다.")
                .languageUsed("JS")
                .build();

        Long noticeId1 = noticeService.save(dto1);
        Long noticeId2 = noticeService.save(dto2);

        //when
        List<RecruitmentNoticeResponseDto> resultsByPosition = noticeService.search("백엔드");
        List<RecruitmentNoticeResponseDto> resultsByLanguage = noticeService.search("js");
        List<RecruitmentNoticeResponseDto> resultsByCompany = noticeService.search("테스트");
        List<RecruitmentNoticeResponseDto> resultsByRegion = noticeService.search("제주도");

        //then
        Assertions.assertThat(resultsByPosition).hasSize(12);
        Assertions.assertThat(resultsByLanguage).hasSize(5);
        Assertions.assertThat(resultsByCompany).hasSize(0);
        Assertions.assertThat(resultsByRegion).hasSize(0);


    }

}
