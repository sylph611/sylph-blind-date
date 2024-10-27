package org.sylph.blinddate.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.sylph.blinddate.base.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "users")
@AttributeOverrides({
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @ColumnDefault("1")
    @Column(name = "enabled")
    private Boolean enabled;

}