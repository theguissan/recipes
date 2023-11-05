package br.com.theguissan.recipes.common;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class AbstractService<T, Y> {
    
    private final AbstractRepository<T, Y> repository;
    
    protected AbstractService(final AbstractRepository<T, Y> repository) {
        this.repository = repository;
    }
    
    @Transactional(readOnly = true)
    public List<T> getTodos(final Class<T> dtoClass, final Class<Y> rootClass) {
        return this.repository.getTodos(dtoClass, rootClass);
    }
    
}
