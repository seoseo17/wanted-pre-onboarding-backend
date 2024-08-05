package com.wanted.onboarding.domain.company.service;

import com.wanted.onboarding.common.exception.CustomException;
import com.wanted.onboarding.domain.company.repository.CompanyRepository;
import com.wanted.onboarding.entity.Company;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

import static com.wanted.onboarding.common.response.ErrorCode.COMPANY_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    private final CompanyRepository companyRepository;


    public Company findById(Long companyId){
        return companyRepository.findById(companyId).orElseThrow(()-> new CustomException(COMPANY_NOT_FOUND));
    }


}
