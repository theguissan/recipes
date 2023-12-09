package br.com.theguissan.recipes.cozinheiro;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.theguissan.recipes.common.FuncionarioDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CozinheiroDto extends FuncionarioDto {
    
    private String nomeFantasia;
    
    private Integer quantidadeDeReceitas;
    
    public CozinheiroDto(
            final Long cpf,
            final String nome,
            final LocalDate dataDoContrato,
            final BigDecimal salario,
            final String nomeFantasia,
            final Boolean ativo) {
        super(cpf, nome, dataDoContrato, salario, ativo);
        this.nomeFantasia = nomeFantasia;
    }
    
    public CozinheiroDto(
            final String nome,
            final String nomeFantasia,
            final Long cpf,
            final Integer quantidadeDeReceitas) {
        super(nome);
        this.nomeFantasia = nomeFantasia;
        this.quantidadeDeReceitas = quantidadeDeReceitas;
        this.cpf = cpf;
        
    }
    
    public String getNomeFantasia() {
        return this.nomeFantasia;
    }
    
    public void setNomeFantasia(final String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    
    public Integer getQuantidadeDeReceitas() {
        return this.quantidadeDeReceitas;
    }
    
    public void setQuantidadeDeReceitas(final Integer quantidadeDeReceitas) {
        this.quantidadeDeReceitas = quantidadeDeReceitas;
    }
    
}
