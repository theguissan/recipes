package br.com.theguissan.recipes.cozinheiro;

import java.util.Objects;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.theguissan.recipes.common.BaseForm;
import br.com.theguissan.recipes.common.FuncionarioForm;
import br.com.theguissan.recipes.entity.Cozinheiro;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CozinheiroForm extends FuncionarioForm implements BaseForm<Cozinheiro> {
    
    private String nomeFantasia;
    
    public CozinheiroForm() {
        super();
    }
    
    public String getNomeFantasia() {
        return this.nomeFantasia;
    }
    
    public void setNomeFantasia(final String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    
    @Override
    public Cozinheiro toEntity() {
        final Cozinheiro entity = new Cozinheiro();
        
        entity.setCpf(this.cpf);
        entity.setNome(this.nome);
        entity.setDataDoContrato(this.dataDoContrato);
        
        entity.setSalario(Objects.nonNull(this.salario) ? this.salario : null);
        entity.setNomeFantasia(Objects.nonNull(this.nomeFantasia) ? this.nomeFantasia : null);
        entity.setAtivo(Objects.nonNull(this.ativo) ? this.ativo : null);
        
        return entity;
    }
    
    @Override
    public void Fill(final Cozinheiro entity) {
        
        if (StringUtils.hasText(this.nome)) {
            entity.setNome(this.nome);
        }
        
        if (this.dataDoContrato != null) {
            entity.setDataDoContrato(this.dataDoContrato);
        }
        
        if (this.salario != null) {
            entity.setSalario(this.salario);
        }
        
        if (StringUtils.hasText(this.nomeFantasia)) {
            entity.setNomeFantasia(this.nomeFantasia);
        }
        
        if (this.ativo != null) {
            entity.setAtivo(this.ativo);
        }
    }
    
}
