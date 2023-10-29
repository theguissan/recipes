package br.com.theguissan.recipes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "degustador")
public class Ingrediente {
    
    @Id
    @SequenceGenerator(name = "ingrediente_seq", sequenceName = "ingrediente_cod_ingred_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingrediente_seq")
    @Column(name = "cod_ingred", nullable = false)
    private Integer codigo;
    
    
    @Column(name = "nome_ingred", nullable =     false, unique = true)
    private String nome;
    
    @Column(name = "desc_ingred")
    private String descricao;
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }
    
}
