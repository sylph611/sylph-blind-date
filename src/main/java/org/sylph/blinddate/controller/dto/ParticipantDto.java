package org.sylph.blinddate.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ParticipantDto {
    // 참여자 ID
    private Long id;
    //  참여자 이름
    private String name;
    // 참여자 나이
    private String gender;
    // 참여자 생년
    private Integer birthYear;
    // 참여자 거주지
    private String residence;
    // 참여자 직장 위치
    private String workplaceLocation;
    // 참여자 직장
    private String workplaceName;
    // 참여자 키
    private Integer height;
    // 참여자 학교
    private String schoolName;
    // 참여자 전공
    private String major;
    // 참여자 종교
    private String religion;
    // 참여자 비고
    private String note;
    // 참여자 프로필 이미지
    private String profileImage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
