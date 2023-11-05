package br.com.theguissan.recipes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

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
