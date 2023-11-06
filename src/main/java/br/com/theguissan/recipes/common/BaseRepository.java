package br.com.theguissan.recipes.common;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class BaseRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    protected CriteriaBuilder cb() {
        return this.getEntityManager().getCriteriaBuilder();
    }
    
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
    
}
