package cz.nikolaslada.accountmanager.rest.domains.responses;

import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public class UserResponse {

    private final long id;
    private final String email;
    private final String firstName;
    private final String surname;
    private final boolean active;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime changedAt;

    public UserResponse(long id, String email, String firstName, String surname, boolean active, ZonedDateTime createdAt, ZonedDateTime changedAt) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
        this.active = active;
        this.createdAt = createdAt;
        this.changedAt = changedAt;
    }

}
