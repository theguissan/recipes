package br.com.theguissan.recipes.cozinheiro;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.theguissan.recipes.common.FuncionarioDto;

public class CozinheiroDto extends FuncionarioDto {
    
    private String nomeFantasia;
    
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
    
    public String getNomeFantasia() {
        return this.nomeFantasia;
    }
    
    public void setNomeFantasia(final String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    
}
