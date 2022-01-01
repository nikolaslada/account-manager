package cz.nikolaslada.accountmanager.rest;

import cz.nikolaslada.accountmanager.mappers.UserMapper;
import cz.nikolaslada.accountmanager.repositories.UserJpaRepository;
import cz.nikolaslada.accountmanager.repositories.entities.UserEntity;
import cz.nikolaslada.accountmanager.rest.domains.responses.UserResponse;
import org.springframework.web.bind.annotation.*;

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

}
