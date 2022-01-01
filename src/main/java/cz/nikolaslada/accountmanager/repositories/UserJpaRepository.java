package cz.nikolaslada.accountmanager.repositories;

import cz.nikolaslada.accountmanager.repositories.entities.UserEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class UserJpaRepository {

    private final EntityManager entityManager;
    private final Session session;

    public UserJpaRepository(EntityManager entityManager, Session session) {
        this.entityManager = entityManager;
        this.session = session;
    }

    public UserEntity findById(Long id) {
        return this.entityManager.find(UserEntity.class, id);
    }

    public long createOrUpdate(UserEntity userEntity) {
        this.session.save(userEntity);
        return userEntity.getId();
    }

}
