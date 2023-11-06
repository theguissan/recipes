package br.com.theguissan.recipes.degustador;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.theguissan.recipes.common.FuncionarioDto;

public class DegustadorDto extends FuncionarioDto {

    
    public DegustadorDto(
            final Long cpf,
            final String nome,
            final LocalDate dataDoContrato,
            final BigDecimal salario,
            final Boolean ativo) {
        super(
                cpf,
                nome,
                dataDoContrato,
                salario,
                ativo);
    }

    
}
