package br.com.theguissan.recipes.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "teste")
public class Teste {
    
    @EmbeddedId
    private TesteId codigo;
    
    @Column(name = "dt_test", nullable = false)
    private LocalDate dataDoTeste;
    
    @Column(name = "nota_test", nullable = false)
    private Float nota;
    
    public TesteId getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final TesteId codigo) {
        this.codigo = codigo;
    }
    
    public LocalDate getDataDoTeste() {
        return this.dataDoTeste;
    }
    
    public void setDataDoTeste(final LocalDate dataDoTeste) {
        this.dataDoTeste = dataDoTeste;
    }
    
    public Float getNota() {
        return this.nota;
    }
    
    public void setNota(final Float nota) {
        this.nota = nota;
    }
    
}
