package cz.nikolaslada.accountmanager.mappers;

import cz.nikolaslada.accountmanager.repositories.entities.UserEntity;
import cz.nikolaslada.accountmanager.rest.domains.requests.CurrentUserRequest;
import cz.nikolaslada.accountmanager.rest.domains.requests.NewUserRequest;
import cz.nikolaslada.accountmanager.rest.domains.responses.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.ZonedDateTime;

@Mapper()
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse userEntityToUserResponse(UserEntity entity);

    default UserEntity newUserRequestToUserEntity(
            NewUserRequest request,
            boolean active,
            ZonedDateTime currentDateTime
    ) {
        return new UserEntity(
                request.getEmail(),
                request.getFirstName(),
                request.getSurname(),
                active,
                request.getPassword(),
                currentDateTime,
                null
        );
    };

    default UserEntity currentUserRequestToUserEntity(
            CurrentUserRequest request,
            ZonedDateTime currentDateTime,
            UserEntity currentEntity
    ) {
        String email = request.getEmail();
        String firstName = request.getFirstName();
        String surname = request.getSurname();
        Boolean active = request.getActive();
        String password = request.getPassword();

        return new UserEntity(
                currentEntity.getId(),
                email == null ? currentEntity.getEmail() : email,
                firstName == null ? currentEntity.getFirstName() : firstName,
                surname == null ? currentEntity.getSurname() : surname,
                active == null ? currentEntity.isActive() : active.booleanValue(),
                password == null ? currentEntity.getPassword() : password,
                currentEntity.getCreatedAt(),
                currentDateTime
        );
    };

}
