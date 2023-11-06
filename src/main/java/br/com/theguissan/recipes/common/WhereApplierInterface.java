package br.com.theguissan.recipes.common;

import java.util.List;

import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public interface WhereApplierInterface<E> {
    
    List<Predicate> apply(Root<E> entidade);
    
}
