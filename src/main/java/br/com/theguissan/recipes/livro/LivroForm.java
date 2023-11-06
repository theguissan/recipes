package br.com.theguissan.recipes.livro;

import br.com.theguissan.recipes.common.BaseForm;
import br.com.theguissan.recipes.entity.Livro;

public class LivroForm implements BaseForm<Livro> {
    
    private Integer isbn;
    
    private String titulo;
    
    private Long cpfDoEditor;
    
    @Override
    public Livro toEntity() {
        final Livro entity = new Livro();
        
        entity.setIsbn(this.isbn);
        entity.setTitulo(this.titulo);
        
        return entity;
    }
    
    @Override
    public void Fill(final Livro entity) {
        
        if (this.titulo != null) {
            entity.setTitulo(this.titulo);
        }
        
    }
    
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
    
    public Long getCpfDoEditor() {
        return this.cpfDoEditor;
    }
    
    public void setCpfDoEditor(final Long cpfDoEditor) {
        this.cpfDoEditor = cpfDoEditor;
    }
    
}
