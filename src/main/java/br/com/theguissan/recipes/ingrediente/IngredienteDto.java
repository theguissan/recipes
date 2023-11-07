package br.com.theguissan.recipes.ingrediente;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IngredienteDto {
    
    private Integer codigo;
    
    private String nome;
    
    private String descricao;
    
    public IngredienteDto(final Integer codigo, final String nome, final String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
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
