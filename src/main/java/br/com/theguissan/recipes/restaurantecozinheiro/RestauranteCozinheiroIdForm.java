package br.com.theguissan.recipes.restaurantecozinheiro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestauranteCozinheiroIdForm {
    
    @NotNull(message = "O código do restaurante é obrigatório")
    private Integer codigoDoRestaurante;
    
    @NotNull(message = "O CPF do cozinheiro é obrigatório")
    private Long cpfDoCozinheiro;
    
    public Integer getCodigoDoRestaurante() {
        return this.codigoDoRestaurante;
    }
    
    public void setCodigoDoRestaurante(final Integer codigoDoRestaurante) {
        this.codigoDoRestaurante = codigoDoRestaurante;
    }
    
    public Long getCpfDoCozinheiro() {
        return this.cpfDoCozinheiro;
    }
    
    public void setCpfDoCozinheiro(final Long cpfDoCozinheiro) {
        this.cpfDoCozinheiro = cpfDoCozinheiro;
    }
    
}
