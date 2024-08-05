package com.wanted.onboarding.entity;

import com.wanted.onboarding.domain.recruitmentnotice.dto.update.RecruitmentNoticeUpdateDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "recruitment_notice")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RecruitmentNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "companyId")
    private Company company;

    private String position;

    private int compensation;

    private String content;

    private String languageUsed;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void update(RecruitmentNoticeUpdateDto dto){
        this.position = dto.getPosition();
        this.compensation = dto.getCompensation();
        this.content = dto.getContent();
        this.languageUsed = dto.getLanguageUsed();
    }

}
