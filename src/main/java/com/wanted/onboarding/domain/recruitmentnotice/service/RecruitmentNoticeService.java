package com.wanted.onboarding.domain.recruitmentnotice.service;

import com.wanted.onboarding.common.exception.CustomException;
import com.wanted.onboarding.domain.company.service.CompanyService;
import com.wanted.onboarding.domain.recruitmentnotice.dto.findall.RecruitmentNoticeResponseDto;
import com.wanted.onboarding.domain.recruitmentnotice.dto.findbyid.RecruitmentNoticeDetailResponseDto;
import com.wanted.onboarding.domain.recruitmentnotice.dto.save.RecruitmentNoticeDto;
import com.wanted.onboarding.domain.recruitmentnotice.dto.update.RecruitmentNoticeUpdateDto;
import com.wanted.onboarding.domain.recruitmentnotice.repository.RecruitmentNoticeRepository;
import com.wanted.onboarding.entity.Company;
import com.wanted.onboarding.entity.RecruitmentNotice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    @Transactional(readOnly = true)
    public List<RecruitmentNoticeResponseDto> getAllList(){
        List<RecruitmentNotice> notices = noticeRepository.findAll();

        return notices.stream().map(RecruitmentNoticeResponseDto::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public RecruitmentNoticeDetailResponseDto getNoticeById(Long noticeId){
        // 1. 채용 공고 찾기
        RecruitmentNotice notice = findById(noticeId);

        // 2. 회사가 올린 공고 id 목록 만들기
        List<Long> list = noticeRepository.findIdByCompanyId(notice.getCompany().getId())
                .stream().filter(id -> id != noticeId).collect(Collectors.toList());

        return new RecruitmentNoticeDetailResponseDto(notice,list);
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

    public void delete(Long noticeId){
        RecruitmentNotice notice = findById(noticeId);
        noticeRepository.deleteById(notice.getId());
    }

    public List<RecruitmentNoticeResponseDto> search(String param){

        //1. 검색어가 포함되어 있는 채용공고 찾기
        List<RecruitmentNotice> results = noticeRepository.findByPositionContaining(param);
        if (results.isEmpty()){
            results = noticeRepository.findByLanguageUsedContaining(param);
        }
        if (results.isEmpty()){
            results = noticeRepository.findByCompanyName(param);
        }
        if (results.isEmpty()){
            results = noticeRepository.findByCompanyRegion(param);
        }

        return results.stream().map(RecruitmentNoticeResponseDto::new).collect(Collectors.toList());
    }

}
