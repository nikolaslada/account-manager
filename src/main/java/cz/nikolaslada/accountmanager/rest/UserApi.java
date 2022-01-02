package cz.nikolaslada.accountmanager.rest;

import cz.nikolaslada.accountmanager.mappers.UserMapper;
import cz.nikolaslada.accountmanager.repositories.UserJpaRepository;
import cz.nikolaslada.accountmanager.repositories.entities.UserEntity;
import cz.nikolaslada.accountmanager.rest.domains.requests.CurrentUserRequest;
import cz.nikolaslada.accountmanager.rest.domains.requests.NewUserRequest;
import cz.nikolaslada.accountmanager.rest.domains.responses.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        this.userJpaRepository.createOrUpdate(entity);
        return UserMapper.INSTANCE.userEntityToUserResponse(entity);
    }

    @PatchMapping(
            value = "/user/{id}",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public UserResponse patch(@PathVariable Long id, @RequestBody @Valid CurrentUserRequest request) {
        UserEntity currentEntity = this.userJpaRepository.findById(id);
        UserEntity entity = UserMapper.INSTANCE.currentUserRequestToUserEntity(request, ZonedDateTime.now(), currentEntity);
        this.userJpaRepository.createOrUpdate(currentEntity);
        return UserMapper.INSTANCE.userEntityToUserResponse(entity);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.userJpaRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
