package br.com.theguissan.recipes.receita;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceitaDto {
    
    private Integer codigo;
    
    private String nome;
    
    private LocalDate dataDeCriacao;
    
    private Long cpfDoCozinheiro;
    
    private String nomeDoCozinheiro;
    
    private Integer isbnDoLivro;
    
    private String tituloDoLivro;
    
    private String categoriaDaReceita;
    
    private String descricao;
    
    private Integer porcoes;
    
    public ReceitaDto(
            final Integer codigo,
            final String nome,
            final LocalDate dataDeCriacao,
            final Long cpfDoCozinheiro,
            final String nomeDoCozinheiro,
            final Integer isbnDoLivro,
            final String tituloDoLivro,
            final String categoriaDaReceita,
            final String descricao,
            final Integer porcoes) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataDeCriacao = dataDeCriacao;
        this.cpfDoCozinheiro = cpfDoCozinheiro;
        this.nomeDoCozinheiro = nomeDoCozinheiro;
        this.isbnDoLivro = isbnDoLivro;
        this.tituloDoLivro = tituloDoLivro;
        this.categoriaDaReceita = categoriaDaReceita;
        this.descricao = descricao;
        this.porcoes = porcoes;
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
    
    public String getNomeDoCozinheiro() {
        return this.nomeDoCozinheiro;
    }
    
    public void setNomeDoCozinheiro(final String nomeDoCozinheiro) {
        this.nomeDoCozinheiro = nomeDoCozinheiro;
    }
    
    public Integer getIsbnDoLivro() {
        return this.isbnDoLivro;
    }
    
    public void setIsbnDoLivro(final Integer isbnDoLivro) {
        this.isbnDoLivro = isbnDoLivro;
    }
    
    public String getTituloDoLivro() {
        return this.tituloDoLivro;
    }
    
    public void setTituloDoLivro(final String tituloDoLivro) {
        this.tituloDoLivro = tituloDoLivro;
    }
    
    public String getCategoriaDaReceita() {
        return this.categoriaDaReceita;
    }
    
    public void setCategoriaDaReceita(final String categoriaDaReceita) {
        this.categoriaDaReceita = categoriaDaReceita;
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
