package br.com.theguissan.recipes.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {
    
    @Id
    @Column(name = "cpf_fun", nullable = false)
    private Integer cpf;
    
    @Column(name = "nome_fun", nullable = false)
    private String nome;
    
    @Column(name = "dt_contrato_fun", nullable = false)
    private LocalDate dataDoContrato;
    
    @Column(name= "salario_fun", nullable = true)
    private BigDecimal salario;
    
    public Integer getCpf() {
        return this.cpf;
    }
    
    public void setCpf(final Integer cpf) {
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
    
}
