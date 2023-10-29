package br.com.theguissan.recipes.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "receita")
public class Receita {
    
    
    @Id
    @Column(name = "cod_rec", nullable = false)
    @SequenceGenerator(name = "receita_seq", sequenceName = "receita_cod_rec_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receita_seq")
    private Integer codigo;
    
    @Column(name = "nome_rec", nullable = false, unique = true)
    private String nome;
    
    @Column(name = "dt_criacao_rec", nullable = false)
    private LocalDate dataDeCriacao;
    
    @ManyToOne
    @JoinColumn(name = "cpf_coz", nullable = false)
    private Cozinheiro cozinheiro;
    
    @ManyToOne
    @JoinColumn(name = "isbn_rec", nullable = false)
    private Livro livro;
    
    @ManyToOne
    @JoinColumn(name = "cod_categoria_rec", nullable = false)
    private CategoriaReceita categoriaReceita;
    
    
    @Column(name = "desc_rec")
    private String descricao;
    
    @Column(name = "porcoes_rec")
    private Integer porcoes;
    
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
    
    public Cozinheiro getCozinheiro() {
        return this.cozinheiro;
    }
    
    public void setCozinheiro(final Cozinheiro cozinheiro) {
        this.cozinheiro = cozinheiro;
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
    
    public Livro getLivro() {
        return this.livro;
    }
    
    public void setLivro(final Livro livro) {
        this.livro = livro;
    }
    
    public CategoriaReceita getCategoriaReceita() {
        return this.categoriaReceita;
    }
    
    public void setCategoriaReceita(final CategoriaReceita categoriaReceita) {
        this.categoriaReceita = categoriaReceita;
    }
    
}
