package br.com.theguissan.recipes.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "funcionario")
public class Funcionario {
    
    @Id
    @Column(name = "cpf_fun", nullable = false, unique = true)
    private Long cpf;
    
    @Column(name = "nome_fun", nullable = false)
    private String nome;
    
    @Column(name = "dt_contrato_fun", nullable = false)
    private LocalDate dataDoContrato;
    
    @Column(name = "salario_fun", nullable = true)
    private BigDecimal salario;
    
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
    
}
