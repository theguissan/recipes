package br.com.theguissan.recipes.common;

import java.util.List;
import java.util.Optional;

public interface StandardRepositotyInterface<T, C, E> {
    
    List<T> getTodos();
    
    Optional<T> getPorCodigo(C chave);
    
    void insert(E entity);
    
}
