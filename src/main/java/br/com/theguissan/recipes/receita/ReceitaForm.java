package br.com.theguissan.recipes.receita;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.theguissan.recipes.common.BaseForm;
import br.com.theguissan.recipes.entity.Receita;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceitaForm implements BaseForm<Receita> {
    
    @NotNull(message = "O nome da receita não pode ser nulo.")
    private String nome;
    
    @NotNull(message = "A data de criação da receita não pode ser nula.")
    private LocalDate dataDeCriacao;
    
    @NotNull(message = "O código do cozinheiro não pode ser nulo.")
    private Long cpfDoCozinheiro;
    
    @NotNull(message = "O ISBN do livro não pode ser nulo.")
    private Integer isbnDoLivro;
    
    @NotNull(message = "O código da categoria não pode ser nulo.")
    private Integer codigoDaCategoria;
    
    private String descricao;
    
    private Integer porcoes;
    
    @Override
    public Receita toEntity() {
        
        final Receita entity = new Receita();
        
        entity.setNome(this.nome);
        entity.setDataDeCriacao(this.dataDeCriacao);
        entity.setDescricao(this.descricao);
        entity.setPorcoes(this.porcoes);
        
        return entity;
    }
    
    @Override
    public void Fill(final Receita entity) {
        
        if (StringUtils.hasText(this.descricao)) {
            entity.setDescricao(this.descricao);
        }
        
        if (Objects.nonNull(this.dataDeCriacao)) {
            entity.setDataDeCriacao(this.dataDeCriacao);
        }
        
        if (StringUtils.hasText(this.nome)) {
            entity.setNome(this.nome);
        }
        
        if (Objects.nonNull(this.porcoes)) {
            entity.setPorcoes(this.porcoes);
        }
        
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public LocalDate getDataDeCriacao() {
        return this.dataDeCriacao;
    }
    
    public void setDataDeCriacao(final LocalDate dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }
    
    public Long getCpfDoCozinheiro() {
        return this.cpfDoCozinheiro;
    }
    
    public void setCpfDoCozinheiro(final Long cpfDoCozinheiro) {
        this.cpfDoCozinheiro = cpfDoCozinheiro;
    }
    
    public Integer getIsbnDoLivro() {
        return this.isbnDoLivro;
    }
    
    public void setIsbnDoLivro(final Integer isbnDoLivro) {
        this.isbnDoLivro = isbnDoLivro;
    }
    
    public Integer getCodigoDaCategoria() {
        return this.codigoDaCategoria;
    }
    
    public void setCodigoDaCategoria(final Integer codigoDaCategoria) {
        this.codigoDaCategoria = codigoDaCategoria;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getPorcoes() {
        return this.porcoes;
    }
    
    public void setPorcoes(final Integer porcoes) {
        this.porcoes = porcoes;
    }
    
}
