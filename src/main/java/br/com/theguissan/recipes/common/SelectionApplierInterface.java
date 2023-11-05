package br.com.theguissan.recipes.common;

import java.util.List;

import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

public interface SelectionApplierInterface<Y> {
    
    List<Selection<?>> getSelection(Root<Y> from);
    
}
