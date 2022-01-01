package cz.nikolaslada.accountmanager.rest;

import cz.nikolaslada.accountmanager.mappers.UserMapper;
import cz.nikolaslada.accountmanager.repositories.UserJpaRepository;
import cz.nikolaslada.accountmanager.repositories.entities.UserEntity;
import cz.nikolaslada.accountmanager.rest.domains.requests.NewUserRequest;
import cz.nikolaslada.accountmanager.rest.domains.responses.UserResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;

@RestController
public class UserApi {

    private final UserJpaRepository userJpaRepository;

    public UserApi(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        UserEntity entity = this.userJpaRepository.findById(id);
        return UserMapper.INSTANCE.userEntityToUserResponse(entity);
    }

    @PostMapping(
            value = "/user",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public UserResponse post(@RequestBody @Valid NewUserRequest request) {
        UserEntity entity = UserMapper.INSTANCE.newUserRequestToUserEntity(request, true, ZonedDateTime.now());
        this.userJpaRepository.create(entity);
        return UserMapper.INSTANCE.userEntityToUserResponse(entity);
    }

}
