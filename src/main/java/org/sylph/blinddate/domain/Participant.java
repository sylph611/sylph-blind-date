package org.sylph.blinddate.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.sylph.blinddate.base.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "participants")
@Builder
@AttributeOverrides({
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
@NoArgsConstructor
@AllArgsConstructor
public class Participant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull
    @Lob
    @Column(name = "gender", nullable = false)
    private String gender;

    @NotNull
    @Column(name = "birth_year", nullable = false)
    private Integer birthYear;

    @Size(max = 100)
    @NotNull
    @Column(name = "residence", nullable = false, length = 100)
    private String residence;

    @Size(max = 100)
    @Column(name = "job", length = 100)
    private String job;

    @Size(max = 100)
    @NotNull
    @Column(name = "workplace_location", nullable = false, length = 100)
    private String workplaceLocation;

    @Size(max = 100)
    @NotNull
    @Column(name = "workplace_name", nullable = false, length = 100)
    private String workplaceName;

    @Column(name = "height", columnDefinition = "smallint UNSIGNED")
    private Integer height;

    @Size(max = 100)
    @Column(name = "school_name", length = 100)
    private String schoolName;

    @Size(max = 100)
    @Column(name = "major", length = 100)
    private String major;

    @Size(max = 50)
    @Column(name = "religion", length = 50)
    private String religion;

    @Lob
    @Column(name = "note")
    private String note;

    @Size(max = 255)
    @Column(name = "profile_image")
    private String profileImage;

}