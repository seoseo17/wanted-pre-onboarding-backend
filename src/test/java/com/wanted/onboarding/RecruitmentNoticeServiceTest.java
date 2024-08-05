package com.wanted.onboarding;

import com.wanted.onboarding.domain.recruitmentnotice.dto.RecruitmentNoticeDto;
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

@SpringBootTest
class RecruitmentNoticeServiceTest {

    @Autowired
    RecruitmentNoticeService noticeService;

    @Autowired
    RecruitmentNoticeRepository noticeRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("ALTER TABLE recruitment_notice AUTO_INCREMENT = 1");
    }


    @AfterEach
    void afterEach() {
        noticeRepository.deleteAll();
    }

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

        Company company = Company.builder()
                .id(dto.getCompanyId())
                .name("테스트회사")
                .nation("한국")
                .region("제주도")
                .build();

        Long noticeId = noticeService.save(dto);

        RecruitmentNotice notice = noticeRepository.findById(noticeId).orElseThrow();

        Assertions.assertThat(notice.getId()).isEqualTo(1L);


    }

}
