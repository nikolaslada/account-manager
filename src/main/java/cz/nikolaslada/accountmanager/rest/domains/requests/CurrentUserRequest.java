package cz.nikolaslada.accountmanager.rest.domains.requests;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
public class CurrentUserRequest {

    @Email(message = "email is not valid")
    @Size(min = 5, max = 255, message = "email must be between 5 and 255 characters")
    private final String email;

    @Size(min = 1, max = 255, message = "firstName must be between 1 and 255 characters")
    private final String firstName;

    @Size(min = 1, max = 255, message = "surname must be between 1 and 255 characters")
    private final String surname;

    private final Boolean active;

    @Size(min = 8, max = 255, message = "password must be between 8 and 255 characters")
    private final String password;

    public CurrentUserRequest(String email, String firstName, String surname, Boolean active, String password) {
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
        this.active = active;
        this.password = password;
    }

}
