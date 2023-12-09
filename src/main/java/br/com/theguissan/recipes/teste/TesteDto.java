package br.com.theguissan.recipes.teste;

import java.math.BigDecimal;

public class TesteDto {
    
    private String primeiroIngrediente;
    
    private String segundoIngrediente;
    
    private String testador;
    
    private String receita;
    
    private BigDecimal nota;
    
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
    
    public String getTestador() {
        return this.testador;
    }
    
    public void setTestador(final String testador) {
        this.testador = testador;
    }
    
    public String getReceita() {
        return this.receita;
    }
    
    public void setReceita(final String receita) {
        this.receita = receita;
    }
    
    public BigDecimal getNota() {
        return this.nota;
    }
    
    public void setNota(final BigDecimal nota) {
        this.nota = nota;
    }
    
}
