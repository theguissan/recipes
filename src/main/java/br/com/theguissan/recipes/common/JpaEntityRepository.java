package br.com.theguissan.recipes.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class JpaEntityRepository<E> extends BaseRepository {
    
    private Class<E> classeDeE;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    private Class<E> getClasseDeE() {
        if (Objects.isNull(this.classeDeE)) {
            this.classeDeE = GenericUtil.retornarClasseDoDiamante(this.getClass());
        }
        
        return this.classeDeE;
    }
    
    protected <T> List<T> getTodos(final Class<T> dto, final SelectionApplierInterface<E> selection) {
        return this.createTypedQuery(dto, selection, null).getResultList();
    }
    
    protected <T> Optional<T> getPorCodigo(final Class<T> dto, final SelectionApplierInterface<E> selection, final WhereApplierInterface<E> where) {
        
        final TypedQuery<T> query = this.createTypedQuery(dto, selection, where);
        
        try {
            return Optional.of(query.getSingleResult());
            
        } catch (final NoResultException e) {
            
            return Optional.empty();
        }
    }
    
    protected <T> TypedQuery<T> createTypedQuery(final Class<T> dto, final SelectionApplierInterface<E> selectionApplier, final WhereApplierInterface<E> whereApplier) {
        
        final CriteriaQuery<T> criteria = this.cb().createQuery(dto);
        
        final Root<E> from = criteria.from(this.getClasseDeE());
        
        criteria.multiselect(selectionApplier.getSelection(from));
        
        final List<Predicate> predicates = new ArrayList<>();
        
        if (whereApplier != null) {
            
            predicates.addAll(whereApplier.apply(from));
            
            criteria.where(predicates.toArray(new Predicate[0]));
        }
        
        return this.getEntityManager().createQuery(criteria);
    }
    
    public void insert(final E entity) {
        this.getEntityManager().persist(entity);
    }
    
    public <C> E findById(final C id) {
        
        final E entity = this.getEntityManager().find(this.getClasseDeE(), id);
        
        if (entity != null) {
            
            this.entityManager.detach(entity);
            
            return entity;
        }
        
        return null;
    }
    
    public void merge(final E entity) {
        this.getEntityManager().merge(entity);
    }
    
    public <C> void delete(final C id) {
        final E entity = this.getEntityManager().find(this.getClasseDeE(), id);
        this.getEntityManager().remove(entity);
    }
    
}
