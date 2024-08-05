package com.wanted.onboarding.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "recruitment_noitice")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RecruitmentNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "companyId")
    private Company company;

    private String position;

    private int compensation;

    private String content;

    private String languageUsed;

    private String nation;

    private String region;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
