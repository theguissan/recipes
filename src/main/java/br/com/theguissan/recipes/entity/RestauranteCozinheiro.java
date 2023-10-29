package br.com.theguissan.recipes.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
