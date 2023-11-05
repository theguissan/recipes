package br.com.theguissan.recipes.degustador;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.theguissan.recipes.common.FuncionarioDto;

public class DegustadorDto extends FuncionarioDto {
    
    private Boolean ativo;
    
    public DegustadorDto(
            final Long cpf,
            final String nome,
            final LocalDate dataDoContrato,
            final BigDecimal salario,
            final Boolean ativo) {
        super(cpf, nome, dataDoContrato, salario);
        this.ativo = ativo;
    }
    
    public Boolean getAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(final Boolean ativo) {
        this.ativo = ativo;
    }
    
}
