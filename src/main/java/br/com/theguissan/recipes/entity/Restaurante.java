package br.com.theguissan.recipes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "restaurante")
public class Restaurante {
    
    @Id
    @SequenceGenerator(name = "restaurante_seq", sequenceName = "restaurante_cod_rest_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="restaurante_seq")
    @Column(name = "cod_rest", nullable = false)
    private Integer codigo;
    
    @Column(name = "nome_rest", nullable = false)
    private String nome;
    
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
    
}
