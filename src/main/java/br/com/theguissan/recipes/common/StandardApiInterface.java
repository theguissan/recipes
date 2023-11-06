package br.com.theguissan.recipes.common;

import java.util.List;

public interface StandardApiInterface<T, F, C> {
    
    List<T> getTodos();
    
    T getPorCodigo(C chave);
    
    C insert(F form);
    
    void update(C chave, F form);
    
    void delete(C chave);
    
}
