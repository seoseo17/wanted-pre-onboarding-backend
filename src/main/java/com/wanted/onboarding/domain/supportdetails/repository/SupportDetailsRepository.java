package com.wanted.onboarding.domain.supportdetails.repository;

import com.wanted.onboarding.entity.SupportDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportDetailsRepository extends JpaRepository<SupportDetails,Long> {

    boolean existsByUserIdAndRecruitmentNoticeId(Long userId, Long recruitmentNoticeId);
}
