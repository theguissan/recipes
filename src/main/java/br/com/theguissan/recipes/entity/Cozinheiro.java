package br.com.theguissan.recipes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cozinheiro")
public class Cozinheiro extends Funcionario {
    
    @Column(name = "nome_fantasia", nullable = false)
    private String nomeFantasia;
    
    @Column(name = "ativo_coz", nullable = false)
    private Boolean ativo;
    
    public String getNomeFantasia() {
        return this.nomeFantasia;
    }
    
    public void setNomeFantasia(final String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    
    public Boolean getAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(final Boolean ativo) {
        this.ativo = ativo;
    }
    
}
