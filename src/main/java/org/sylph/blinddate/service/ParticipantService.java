package org.sylph.blinddate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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
}
