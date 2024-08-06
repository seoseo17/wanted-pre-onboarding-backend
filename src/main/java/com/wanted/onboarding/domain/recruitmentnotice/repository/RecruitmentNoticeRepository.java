package com.wanted.onboarding.domain.recruitmentnotice.repository;

import com.wanted.onboarding.entity.RecruitmentNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecruitmentNoticeRepository extends JpaRepository<RecruitmentNotice, Long> {
    Optional<RecruitmentNotice> findById(Long noticeId);

    @Query("SELECT rn.id FROM RecruitmentNotice rn WHERE rn.company.id = :companyId")
    List<Long> findIdByCompanyId(Long companyId);

    List<RecruitmentNotice> findByPositionContaining(String position);

    List<RecruitmentNotice> findByLanguageUsedContaining(String languageUsed);

    @Query("select rn from RecruitmentNotice rn where rn.company.name like %:companyName%")
    List<RecruitmentNotice> findByCompanyName(@Param("companyName") String companyName);

    @Query("select rn from RecruitmentNotice rn where rn.company.region like %:companyRegion%")
    List<RecruitmentNotice> findByCompanyRegion(@Param("companyRegion") String companyRegion);

}
