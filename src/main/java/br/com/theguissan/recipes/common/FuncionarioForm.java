package br.com.theguissan.recipes.common;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.theguissan.recipes.entity.Funcionario;
import jakarta.validation.constraints.NotNull;

public class FuncionarioForm {
    
    @NotNull(message = "Cpf é obrigatório")
    protected Long cpf;
    
    @NotNull(message = "Nome é obrigatório")
    protected String nome;
    
    @NotNull(message = "Data do contrato é obrigatório")
    protected LocalDate dataDoContrato;
    
    protected BigDecimal salario;
    
    protected Boolean ativo;
    
    public FuncionarioForm() {}
    
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
    
    public Funcionario toFuncionarioEntity() {
        
        final Funcionario entity = new Funcionario();
        
        entity.setCpf(this.cpf);
        entity.setNome(this.nome);
        entity.setDataDoContrato(this.dataDoContrato);
        entity.setSalario(this.salario);
        
        return entity;
    }
    
    public void fillFuncionario(final Funcionario entity) {
        
        if (this.nome != null) {
            entity.setNome(this.nome);
        }
        
        if (this.dataDoContrato != null) {
            entity.setDataDoContrato(this.dataDoContrato);
        }
        
        if (this.salario != null) {
            entity.setSalario(this.salario);
        }
        
    }
    
}
