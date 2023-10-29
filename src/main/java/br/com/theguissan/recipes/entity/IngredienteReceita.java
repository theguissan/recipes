package br.com.theguissan.recipes.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingrediente_receita")
public class IngredienteReceita {
    
    
    @EmbeddedId
    private IngredienteReceitaId codigo;
    
    @Column(name = "quant_ingrec", nullable = false)
    private Float quantidade;
    
    @Column(name = "med_ingrec")
    private String medidas;
    
    public IngredienteReceitaId getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final IngredienteReceitaId codigo) {
        this.codigo = codigo;
    }
    
    public Float getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(final Float quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getMedidas() {
        return this.medidas;
    }
    
    public void setMedidas(final String medidas) {
        this.medidas = medidas;
    }
    
}
