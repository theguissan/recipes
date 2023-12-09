package br.com.theguissan.recipes.teste;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TesteForm {
    
    private String primeiroIngrediente;
    
    private String segundoIngrediente;
    
    public TesteForm() {}
    
    public String getPrimeiroIngrediente() {
        return this.primeiroIngrediente;
    }
    
    public void setPrimeiroIngrediente(final String primeiroIngrediente) {
        this.primeiroIngrediente = primeiroIngrediente;
    }
    
    public String getSegundoIngrediente() {
        return this.segundoIngrediente;
    }
    
    public void setSegundoIngrediente(final String segundoIngrediente) {
        this.segundoIngrediente = segundoIngrediente;
    }
    
}
