package br.com.theguissan.recipes.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.theguissan.recipes.entity.Receita;
import br.com.theguissan.recipes.entity.Ingrediente;
@Embeddable
public class IngredienteReceitaId implements Serializable {
    
    @Serial
    private static final long serialVersionUID = -5596333490273850249L;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "cod_rec_ingrec", nullable = false)
    private  Receita  receita;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "cod_ing_ingrec", nullable = false)
    private Ingrediente ingrediente;
    
    public IngredienteReceitaId() {}
    
    public Receita getReceita() {
        return this.receita;
    }
    
    public void setReceita(final Receita receita) {
        this.receita = receita;
    }
    
    public Ingrediente getIngrediente() {
        return this.ingrediente;
    }
    
    public void setIngrediente(final Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final IngredienteReceitaId that = (IngredienteReceitaId) o;
        return Objects.equals(this.receita, that.receita) && Objects.equals(this.ingrediente, that.ingrediente);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.receita, this.ingrediente);
    }
    
}
