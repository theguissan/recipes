package br.com.theguissan.recipes.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class TesteId implements Serializable {
    
    private static final long serialVersionUID = -5596333490273850249L;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "cpf_deg_test", nullable = false)
    private Degustador degustador;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "cod_rec_test", nullable = false)
    private Receita receita;
    
    public TesteId() {}
    
    public Degustador getDegustador() {
        return this.degustador;
    }
    
    public void setDegustador(final Degustador degustador) {
        this.degustador = degustador;
    }
    
    public Receita getReceita() {
        return this.receita;
    }
    
    public void setReceita(final Receita receita) {
        this.receita = receita;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final TesteId testeId = (TesteId) o;
        return Objects.equals(this.degustador, testeId.degustador) && Objects.equals(this.receita, testeId.receita);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.degustador, this.receita);
    }
    
}
