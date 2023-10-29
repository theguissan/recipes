package br.com.theguissan.recipes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "editor")
public class Editor extends Funcionario{

    @Column(name= "ativo_edt", nullable = false)
    private Boolean ativo;
    
    public Boolean getAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(final Boolean ativo) {
        this.ativo = ativo;
    }
    
}
