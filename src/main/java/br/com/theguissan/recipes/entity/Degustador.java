package br.com.theguissan.recipes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "degustador")
public class Degustador extends Funcionario {
    
    @Column(name = "ativo_deg", nullable = false)
    private Boolean ativo;
    
    public Boolean getAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(final Boolean ativo) {
        this.ativo = ativo;
    }
    
}
