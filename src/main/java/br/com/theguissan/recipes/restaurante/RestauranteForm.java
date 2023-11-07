package br.com.theguissan.recipes.restaurante;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.theguissan.recipes.common.BaseForm;
import br.com.theguissan.recipes.entity.Restaurante;
import jakarta.validation.constraints.NotNull;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestauranteForm implements BaseForm<Restaurante> {
    
    @NotNull(message = "O nome do restaurante é obrigatório.")
    private String nome;
    
    @Override
    public Restaurante toEntity() {
        final Restaurante entity = new Restaurante();
        
        entity.setNome(this.nome);
        
        return entity;
    }
    
    @Override
    public void Fill(final Restaurante entity) {
        
        if (StringUtils.hasText(this.nome)) {
            entity.setNome(this.nome);
        }
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
}
