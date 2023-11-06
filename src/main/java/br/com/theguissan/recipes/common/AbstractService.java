package br.com.theguissan.recipes.common;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.theguissan.recipes.common.exceptions.NotFoundException;

@Service
public abstract class AbstractService<X, Y, Z extends BaseForm<X>, S> implements ServiceOperationsInterface<X, Z, S> {
    
    private final AbstractRepository<X, Y, Z, S> repository;
    
    protected AbstractService(final AbstractRepository<X, Y, Z, S> repository) {
        this.repository = repository;
    }
    
    @Transactional(readOnly = true)
    public List<Y> getTodos() {
        return this.repository.getTodos();
    }
    
    @Transactional(readOnly = true)
    public Y getPorCodigo(final S chave) {
        return this.repository.getPorCodigo(chave).orElseThrow(() -> new NotFoundException("Dado não encontrado"));
    }
    
}
