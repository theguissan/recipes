package br.com.theguissan.recipes.restaurantecozinheiro;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestauranteCozinheiroDto {
    
    private Integer codigoDoRestaurante;
    
    private String nomeDoRestaurante;
    
    private Long cpfDoCozinheiro;
    
    private String nomeDoCozinheiro;
    
    private LocalDate dataDeContratacao;
    
    public RestauranteCozinheiroDto(
            final Integer codigoDoRestaurante,
            final String nomeDoRestaurante,
            final Long cpfDoCozinheiro,
            final String nomeDoCozinheiro,
            final LocalDate dataDeContratacao) {
        this.codigoDoRestaurante = codigoDoRestaurante;
        this.nomeDoRestaurante = nomeDoRestaurante;
        this.cpfDoCozinheiro = cpfDoCozinheiro;
        this.nomeDoCozinheiro = nomeDoCozinheiro;
        this.dataDeContratacao = dataDeContratacao;
    }
    
    public String getNomeDoRestaurante() {
        return this.nomeDoRestaurante;
    }
    
    public void setNomeDoRestaurante(final String nomeDoRestaurante) {
        this.nomeDoRestaurante = nomeDoRestaurante;
    }
    
    public String getNomeDoCozinheiro() {
        return this.nomeDoCozinheiro;
    }
    
    public void setNomeDoCozinheiro(final String nomeDoCozinheiro) {
        this.nomeDoCozinheiro = nomeDoCozinheiro;
    }
    
    public LocalDate getDataDeContratacao() {
        return this.dataDeContratacao;
    }
    
    public void setDataDeContratacao(final LocalDate dataDeContratacao) {
        this.dataDeContratacao = dataDeContratacao;
    }
    
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
