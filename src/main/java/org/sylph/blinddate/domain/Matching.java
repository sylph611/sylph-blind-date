package org.sylph.blinddate.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.sylph.blinddate.base.BaseEntity;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "matchings")
@AttributeOverrides({
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class Matching extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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

}