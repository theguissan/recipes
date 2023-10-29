package br.com.theguissan.recipes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "categoria_receita")
public class CategoriaReceita {
    
    @Id
    @SequenceGenerator(name = "categoria_receita_seq", sequenceName = "categoria_receita_cod_cat_rec_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_receita_seq")
    @Column(name = "cod_cat_rec", nullable = false)
    private Integer codigo;
    
    @Column(name = "desc_cat_rec", nullable = false)
    private String descricao;
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }
    
}
