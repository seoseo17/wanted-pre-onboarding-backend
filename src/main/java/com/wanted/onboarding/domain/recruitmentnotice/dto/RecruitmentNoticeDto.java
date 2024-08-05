package com.wanted.onboarding.domain.recruitmentnotice.dto;

import com.wanted.onboarding.entity.Company;
import com.wanted.onboarding.entity.RecruitmentNotice;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentNoticeDto {

    @NotNull(message = "회사 ID는 필수 값입니다.")
    @Min(value = 1, message = "1 이상부터 가능합니다.")
    private Long companyId;

    @NotEmpty(message = "채용포지션은 필수 값입니다.")
    private String position;

    @NotNull(message = "채용보상금은 필수 값입니다.")
    @Min(value = 0, message = "양수만 입력 가능합니다.")
    private int compensation;

    @NotEmpty(message = "채용내용은 필수 값입니다.")
    private String content;

    @NotEmpty(message = "사용기술은 필수 값입니다.")
    private String languageUsed;


    /**
     * DTO를 엔티티로 변환합니다.
     *
     * @param company 변환할 회사 엔티티(companyId로 조회)
     * @return 변환된 RecruitmentNotice 엔티티
     */
    public RecruitmentNotice toEntity(Company company){
        return RecruitmentNotice.builder()
                .company(company)
                .position(this.position)
                .compensation(this.compensation)
                .content(this.content)
                .languageUsed(this.languageUsed)
                .build();
    }

}
