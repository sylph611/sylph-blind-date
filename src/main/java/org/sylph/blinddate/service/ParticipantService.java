package org.sylph.blinddate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.sylph.blinddate.controller.dto.ParticipantDto;
import org.sylph.blinddate.domain.Participant;
import org.sylph.blinddate.mapper.ParticipantMapper;
import org.sylph.blinddate.repository.ParticipantRepository;

@Service
@RequiredArgsConstructor
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public Page<ParticipantDto> getParticipants(Pageable pageable) {
        return participantRepository.findAll(pageable).map(ParticipantMapper::toDto);
    }

    public ParticipantDto getParticipant(Long id) {
        Participant participant = participantRepository.findById(id).orElseThrow(() -> new RuntimeException("Participant not found: " + id));
        return ParticipantMapper.toDto(participant);
    }

    public void saveParticipant(ParticipantDto participantDto) {
        Participant participant = ParticipantMapper.toEntity(participantDto);
        if(ObjectUtils.isEmpty(participant)) throw new RuntimeException("Participant is empty");
        participantRepository.save(participant);
    }

    public void updateParticipant(Long id, ParticipantDto dto) {
        participantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participant not found: " + id));
        Participant participant = ParticipantMapper.toEntity(dto);
        if(ObjectUtils.isEmpty(participant)) throw new RuntimeException("Participant is empty");
        participantRepository.save(participant);
    }

    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}