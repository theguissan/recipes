package br.com.theguissan.recipes.categoriareceita;

import br.com.theguissan.recipes.entity.CategoriaReceita;
import br.com.theguissan.recipes.entity.CategoriaReceita_;
import br.com.theguissan.recipes.entity.Receita;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public class CategoriaReceitaFromWrapper {
    
    private final Root<CategoriaReceita> from;
    
    private final Join<CategoriaReceita, Receita> joinReceita;
    
    public CategoriaReceitaFromWrapper(final Root<CategoriaReceita> from) {
        this.from = from;
        this.joinReceita = from.join(CategoriaReceita_.receitas, JoinType.LEFT);
    }
    
    public Root<CategoriaReceita> getFrom() {
        return this.from;
    }
    
    public Join<CategoriaReceita, Receita> getJoinReceita() {
        return this.joinReceita;
    }
    
}
