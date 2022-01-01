package cz.nikolaslada.accountmanager.repositories;

import cz.nikolaslada.accountmanager.repositories.entities.UserEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class UserJpaRepository {

    private final EntityManager entityManager;

    public UserJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UserEntity findById(Long id) {
        return this.entityManager.find(UserEntity.class, id);
    }

}
