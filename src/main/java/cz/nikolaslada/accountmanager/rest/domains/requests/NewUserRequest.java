package cz.nikolaslada.accountmanager.rest.domains.requests;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class NewUserRequest {

    @NotBlank(message = "email is required")
    @Email(message = "email is not valid")
    @Size(min = 5, max = 255, message = "email must be between 5 and 255 characters")
    private final String email;

    @NotBlank(message = "firstName is required")
    @Size(min = 1, max = 255, message = "firstName must be between 1 and 255 characters")
    private final String firstName;

    @NotBlank(message = "surname is required")
    @Size(min = 1, max = 255, message = "surname must be between 1 and 255 characters")
    private final String surname;

    @NotBlank(message = "password is required")
    @Size(min = 8, max = 255, message = "password must be between 8 and 255 characters")
    private final String password;

    public NewUserRequest(String email, String firstName, String surname, String password) {
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
        this.password = password;
    }

}
