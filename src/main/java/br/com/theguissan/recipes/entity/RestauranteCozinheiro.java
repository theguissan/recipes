package br.com.theguissan.recipes.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurante_cozinheiro")
public class RestauranteCozinheiro {
    
    @EmbeddedId
    private RestauranteCozinheiroId codigo;
    
    @Column(name = "dt_contratacao", nullable = false)
    private LocalDate dataDeContratacao;
    
    public RestauranteCozinheiroId getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final RestauranteCozinheiroId codigo) {
        this.codigo = codigo;
    }
    
    public LocalDate getDataDeContratacao() {
        return this.dataDeContratacao;
    }
    
    public void setDataDeContratacao(final LocalDate dataDeContratacao) {
        this.dataDeContratacao = dataDeContratacao;
    }
    
}
