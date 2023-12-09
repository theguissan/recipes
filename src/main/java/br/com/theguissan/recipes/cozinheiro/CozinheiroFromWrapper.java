package br.com.theguissan.recipes.cozinheiro;

import br.com.theguissan.recipes.entity.Cozinheiro;
import br.com.theguissan.recipes.entity.Cozinheiro_;
import br.com.theguissan.recipes.entity.Receita;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

public class CozinheiroFromWrapper {
    
    private final Root<Cozinheiro> from;
    
    private final Join<Cozinheiro, Receita> joinReceita;
    
    public CozinheiroFromWrapper(final Root<Cozinheiro> from) {
        this.from = from;
        this.joinReceita = this.from.join(Cozinheiro_.receitas);
    }
    
    public Root<Cozinheiro> getFrom() {
        return this.from;
    }
    
    public Join<Cozinheiro, Receita> getJoinReceita() {
        return this.joinReceita;
    }
    
}
