package org.sylph.blinddate.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "matchings")
public class Matching {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matching_id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "male_participant_id", nullable = false)
    private Participant maleParticipant;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "female_participant_id", nullable = false)
    private Participant femaleParticipant;

    @NotNull
    @Column(name = "matched_at", nullable = false)
    private LocalDate matchedAt;

    @NotNull
    @ColumnDefault("'PENDING'")
    @Lob
    @Column(name = "status", nullable = false)
    private String status;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

}