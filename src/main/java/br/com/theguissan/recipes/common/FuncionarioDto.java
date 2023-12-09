package br.com.theguissan.recipes.common;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuncionarioDto {
    
    protected Long cpf;
    
    protected String nome;
    
    protected LocalDate dataDoContrato;
    
    protected BigDecimal salario;
    
    protected Boolean ativo;
    
    public FuncionarioDto() {}
    
    public FuncionarioDto(
            final Long cpf,
            final String nome,
            final LocalDate dataDoContrato,
            final BigDecimal salario,
            final Boolean ativo) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataDoContrato = dataDoContrato;
        this.salario = salario;
        this.ativo = ativo;
    }
    
    public FuncionarioDto(final String nome) {
        this.nome = nome;
    }
    
    public Long getCpf() {
        return this.cpf;
    }
    
    public void setCpf(final Long cpf) {
        this.cpf = cpf;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public LocalDate getDataDoContrato() {
        return this.dataDoContrato;
    }
    
    public void setDataDoContrato(final LocalDate dataDoContrato) {
        this.dataDoContrato = dataDoContrato;
    }
    
    public BigDecimal getSalario() {
        return this.salario;
    }
    
    public void setSalario(final BigDecimal salario) {
        this.salario = salario;
    }
    
    public Boolean getAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(final Boolean ativo) {
        this.ativo = ativo;
    }
    
}
