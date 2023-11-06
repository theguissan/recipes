package br.com.theguissan.recipes.common;

public interface ServiceOperationsInterface<E, F extends BaseForm<E>, C> {
    
    C insert(F form);
    
    void update(C chave, F form);
    
    void delete(C chave);
    
}
