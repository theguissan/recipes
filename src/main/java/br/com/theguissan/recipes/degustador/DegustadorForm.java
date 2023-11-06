package br.com.theguissan.recipes.degustador;

import org.springframework.util.StringUtils;

import br.com.theguissan.recipes.common.BaseForm;
import br.com.theguissan.recipes.common.FuncionarioForm;
import br.com.theguissan.recipes.entity.Degustador;

public class DegustadorForm extends FuncionarioForm implements BaseForm<Degustador> {

    
    @Override
    public Degustador toEntity() {
        Degustador entity = new Degustador();
        
        entity.setCpf(this.cpf);
        entity.setNome(this.nome);
        entity.setDataDoContrato(this.dataDoContrato);
        entity.setSalario(this.salario);
        entity.setAtivo(this.ativo);
        
        return entity;
    }
    
    @Override
    public void Fill(final Degustador entity) {
        
            if (StringUtils.hasText(this.nome)) {
                entity.setNome(this.nome);
            }
            
            if (this.dataDoContrato != null) {
                entity.setDataDoContrato(this.dataDoContrato);
            }
            
            if (this.salario != null) {
                entity.setSalario(this.salario);
            }
            
            if (this.ativo != null) {
                entity.setAtivo(this.ativo);
            }
    }
    
}
