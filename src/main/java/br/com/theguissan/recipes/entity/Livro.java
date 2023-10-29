package br.com.theguissan.recipes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
    
    @Id
    @Column(name = "isbn", nullable = false)
    private Integer isbn;
    
    @Column(name = "titulo_livro", nullable = false)
    private String titulo;
    
    @ManyToOne
    @JoinColumn(name = "cpf_edit", nullable = false)
    private Editor editor;
    
    public Integer getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(final Integer isbn) {
        this.isbn = isbn;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }
    
    public Editor getEditor() {
        return this.editor;
    }
    
    public void setEditor(final Editor editor) {
        this.editor = editor;
    }
    
}
