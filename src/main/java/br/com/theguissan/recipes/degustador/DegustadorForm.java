package br.com.theguissan.recipes.degustador;

import br.com.theguissan.recipes.common.BaseForm;
import br.com.theguissan.recipes.common.FuncionarioForm;
import br.com.theguissan.recipes.entity.Degustador;

public class DegustadorForm extends FuncionarioForm implements BaseForm<Degustador> {
    
    private Boolean ativo;
    
    @Override
    public Degustador toEntity() {
        return null;
    }
    
    @Override
    public void Fill(final Degustador entity) {
    
    }
    
}
