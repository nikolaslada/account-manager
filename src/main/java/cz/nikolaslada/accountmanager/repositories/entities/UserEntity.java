package cz.nikolaslada.accountmanager.repositories.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "users_id", columnDefinition = "INT UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @NotNull
    private String email;
    @NotNull
    private String firstName;
    @NotNull
    private String surname;
    private boolean active;
    @NotNull
    private String password;
    @NotNull
    private ZonedDateTime createdAt;
    private ZonedDateTime changedAt;

    public UserEntity(String email, String firstName, String surname, boolean active, String password, ZonedDateTime createdAt, ZonedDateTime changedAt) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
        this.active = active;
        this.password = password;
        this.createdAt = createdAt;
        this.changedAt = changedAt;
    }

    public UserEntity(long id, String email, String firstName, String surname, boolean active, String password, ZonedDateTime createdAt, ZonedDateTime changedAt) {
        super();
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
        this.active = active;
        this.password = password;
        this.createdAt = createdAt;
        this.changedAt = changedAt;
    }

}
