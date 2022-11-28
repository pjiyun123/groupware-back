package com.team4.groupwareproject.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo; // 회원 번호

    @Column(nullable=false)
    private String userNum; // 회원 사원번호

    @Column(nullable=false, length = 256)
    private String userPwd; // 회원 비밀번호

    @Column(nullable=false, length=20)
    private String userNm; // 회원 이름

    @Column(nullable=false, length=100)
    private String userEmail; // 회원 이메일

    @Column(nullable=false)
    private LocalDate userBirth; // 회원 생년월일

    @Column(nullable=true)
    private String userPhone; // 회원 프로필 사진

    @Column(nullable = false)
    private LocalDateTime createDt; // 회원정보 생성일자

    @Column(nullable = true)
    private LocalDateTime updateDt; // 회원정보 수정일자

    @Column(nullable = true)
    private LocalDateTime deleteDt; // 회원정보 삭제일자

    /* FK */
    @Column(nullable=true)
    private Long userLv; // 회원 권한번호

    @Column(nullable=true)
    private Long deptNo; // 부서 번호

    @Column(nullable=true)
    private Long jobNo; // 직급 번호

}
