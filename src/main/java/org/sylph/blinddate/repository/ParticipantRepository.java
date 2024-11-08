package org.sylph.blinddate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sylph.blinddate.domain.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
