package br.com.theguissan.recipes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurante")
public class Restaurante {
    
    @Id
    @SequenceGenerator(name = "restaurante_seq", sequenceName = "restaurante_cod_rest_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurante_seq")
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
