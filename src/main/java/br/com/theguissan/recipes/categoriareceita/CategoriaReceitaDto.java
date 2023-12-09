package br.com.theguissan.recipes.categoriareceita;

public class CategoriaReceitaDto {
    
    private Integer codigo;
    
    private String descricao;
    
    private Long quantidadeDeReceitas;
    
    public CategoriaReceitaDto(final Integer codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public CategoriaReceitaDto(final Integer codigo, final String descricao, final Long quantidadeDeReceitas) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidadeDeReceitas = quantidadeDeReceitas;
    }
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }
    
    public Long getQuantidadeDeReceitas() {
        return this.quantidadeDeReceitas;
    }
    
    public void setQuantidadeDeReceitas(final Long quantidadeDeReceitas) {
        this.quantidadeDeReceitas = quantidadeDeReceitas;
    }
    
}
