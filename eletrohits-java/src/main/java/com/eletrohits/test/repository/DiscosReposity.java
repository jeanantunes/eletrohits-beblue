package com.eletrohits.test.repository;

import com.eletrohits.test.model.Discos;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DiscosReposity {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Discos discos) {
        entityManager.persist(discos);
        return;
    }

    public void delete(Discos discos) {
        if (entityManager.contains(discos))
            entityManager.remove(discos);
        else
            entityManager.remove(entityManager.merge(discos));
        return;
    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return entityManager.createQuery("from Discos").getResultList();
    }

    public Discos findById(Long id) {
        return entityManager.find(Discos.class, id);
    }

    public void update(Discos discos) {
        entityManager.merge(discos);
        return;
    }
}
