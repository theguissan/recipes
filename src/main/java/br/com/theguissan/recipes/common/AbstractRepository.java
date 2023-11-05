package br.com.theguissan.recipes.common;

import java.util.List;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public abstract class AbstractRepository<T, Y> extends BaseRepository implements SelectionApplierInterface<Y> {
    
    public List<T> getTodos(final Class<T> dtoClass, final Class<Y> rootClass) {
        
        final CriteriaQuery<T> criteria = this.cb().createQuery(dtoClass);
        
        final Root<Y> from = criteria.from(rootClass);
        
        criteria.multiselect(this.getSelection(from));
        
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
    
}
