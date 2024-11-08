package org.sylph.blinddate.mapper;

import org.springframework.util.ObjectUtils;
import org.sylph.blinddate.controller.dto.ParticipantDto;
import org.sylph.blinddate.domain.Participant;

public class ParticipantMapper {
    // Entity -> DTO 변환 메서드
    public static ParticipantDto toDto(Participant participant) {
        if(ObjectUtils.isEmpty(participant)) return null;

        return ParticipantDto.builder()
                .id(participant.getId())
                .name(participant.getName())
                .gender(participant.getGender())
                .birthYear(participant.getBirthYear())
                .residence(participant.getResidence())
                .workplaceLocation(participant.getWorkplaceLocation())
                .workplaceName(participant.getWorkplaceName())
                .height(participant.getHeight())
                .schoolName(participant.getSchoolName())
                .major(participant.getMajor())
                .religion(participant.getReligion())
                .note(participant.getNote())
                .profileImage(participant.getProfileImage())
                .createdAt(participant.getCreatedAt())
                .updatedAt(participant.getUpdatedAt())
                .build();
    }

    // DTO -> Entity 변환 메서드
    public static Participant toEntity(ParticipantDto dto) {
        if(ObjectUtils.isEmpty(dto)) return null;

        return Participant.builder()
                .id(dto.getId())
                .name(dto.getName())
                .gender(dto.getGender())
                .birthYear(dto.getBirthYear())
                .residence(dto.getResidence())
                .workplaceLocation(dto.getWorkplaceLocation())
                .workplaceName(dto.getWorkplaceName())
                .height(dto.getHeight())
                .schoolName(dto.getSchoolName())
                .major(dto.getMajor())
                .religion(dto.getReligion())
                .note(dto.getNote())
                .profileImage(dto.getProfileImage())
                .build();

    }
}
