package br.com.theguissan.recipes.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroDto {
    
    private Integer isbn;
    
    private String titulo;
    
    private String editor;
    
    public LivroDto(final Integer isbn, final String titulo, final String editor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editor = editor;
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
    
    public String getEditor() {
        return this.editor;
    }
    
    public void setEditor(final String editor) {
        this.editor = editor;
    }
    
}
