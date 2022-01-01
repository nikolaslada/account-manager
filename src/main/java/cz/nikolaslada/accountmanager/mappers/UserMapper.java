package cz.nikolaslada.accountmanager.mappers;

import cz.nikolaslada.accountmanager.repositories.entities.UserEntity;
import cz.nikolaslada.accountmanager.rest.domains.responses.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse userEntityToUserResponse(UserEntity entity);

}
