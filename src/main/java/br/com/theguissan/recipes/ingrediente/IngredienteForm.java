package br.com.theguissan.recipes.ingrediente;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.theguissan.recipes.common.BaseForm;
import br.com.theguissan.recipes.entity.Ingrediente;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IngredienteForm implements BaseForm<Ingrediente> {
    
    @NotNull(message = "O código do ingrediente é obrigatório")
    private Integer codigo;
    
    @NotNull(message = "O nome do ingrediente é obrigatório")
    private String nome;
    
    private String descricao;
    
    @Override
    public Ingrediente toEntity() {
        
        final Ingrediente entity = new Ingrediente();
        
        entity.setNome(this.nome);
        entity.setDescricao(this.descricao);
        
        return entity;
    }
    
    @Override
    public void Fill(final Ingrediente entity) {
        
        if (StringUtils.hasText(this.nome)) {
            entity.setNome(this.nome);
        }
        
        if (StringUtils.hasText(this.descricao)) {
            entity.setDescricao(this.descricao);
        }
        
    }
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }
    
}
