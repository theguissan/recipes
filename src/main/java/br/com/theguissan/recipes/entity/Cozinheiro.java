package br.com.theguissan.recipes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cozinheiro")
public class Cozinheiro extends Funcionario{
    
    
    @Column(name = "nome_fantasia_coz", nullable = false)
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
