package cz.nikolaslada.accountmanager.repositories;

import cz.nikolaslada.accountmanager.repositories.entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

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

    public int deleteById(Long id) {
        Transaction transaction = this.session.beginTransaction();
        int deleted = this.createDeleteQuery(id).executeUpdate();
        transaction.commit();
        return deleted;
    }

    private Query createDeleteQuery(Long id) {
        CriteriaBuilder builder = this.session.getCriteriaBuilder();

        CriteriaDelete<UserEntity> criteriaDelete = builder.createCriteriaDelete(UserEntity.class);
        Root<UserEntity> rootTable = criteriaDelete.from(UserEntity.class);
        criteriaDelete.where(builder.equal(rootTable.get("id"), id));

        return this.session.createQuery(criteriaDelete);
    }

}
