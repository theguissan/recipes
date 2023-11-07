package br.com.theguissan.recipes.categoriareceita;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.theguissan.recipes.common.BaseForm;
import br.com.theguissan.recipes.entity.CategoriaReceita;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriaReceitaForm implements BaseForm<CategoriaReceita> {
    
    @NotNull(message = "Descrição é obrigatório")
    private String descricao;
    
    @Override
    public CategoriaReceita toEntity() {
        
        final CategoriaReceita entity = new CategoriaReceita();
        
        entity.setDescricao(this.descricao);
        
        return entity;
    }
    
    @Override
    public void Fill(final CategoriaReceita entity) {
        
        if (StringUtils.hasText(this.descricao)) {
            entity.setDescricao(this.descricao);
        }
        
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }
    
}
