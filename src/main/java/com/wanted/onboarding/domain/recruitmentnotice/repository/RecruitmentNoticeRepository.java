package com.wanted.onboarding.domain.recruitmentnotice.repository;

import com.wanted.onboarding.entity.RecruitmentNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentNoticeRepository extends JpaRepository<RecruitmentNotice, Integer> {

}
