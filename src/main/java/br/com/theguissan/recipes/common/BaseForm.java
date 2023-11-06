package br.com.theguissan.recipes.common;

public interface BaseForm<E> {
    
    E toEntity();
    
    void Fill(E entity);
    
}
