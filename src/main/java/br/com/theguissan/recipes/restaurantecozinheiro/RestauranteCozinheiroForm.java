package br.com.theguissan.recipes.restaurantecozinheiro;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.theguissan.recipes.common.BaseForm;
import br.com.theguissan.recipes.entity.RestauranteCozinheiro;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestauranteCozinheiroForm implements BaseForm<RestauranteCozinheiro> {
    
    @NotNull(message = "Os códigos do restaurante e do cozinheiro são obrigatórios")
    private RestauranteCozinheiroIdForm codigos;
    
    @NotNull(message = "A data da contratação é obrigatória")
    private LocalDate dataDaContracacao;
    
    @Override
    public RestauranteCozinheiro toEntity() {
        
        final RestauranteCozinheiro entity = new RestauranteCozinheiro();
        
        entity.setDataDeContratacao(this.dataDaContracacao);
        
        return entity;
    }
    
    @Override
    public void Fill(final RestauranteCozinheiro entity) {
        
        if (this.dataDaContracacao != null) {
            entity.setDataDeContratacao(this.dataDaContracacao);
        }
        
    }
    
    public RestauranteCozinheiroIdForm getCodigos() {
        return this.codigos;
    }
    
    public void setCodigos(final RestauranteCozinheiroIdForm codigos) {
        this.codigos = codigos;
    }
    
    public LocalDate getDataDaContracacao() {
        return this.dataDaContracacao;
    }
    
    public void setDataDaContracacao(final LocalDate dataDaContracacao) {
        this.dataDaContracacao = dataDaContracacao;
    }
    
}
