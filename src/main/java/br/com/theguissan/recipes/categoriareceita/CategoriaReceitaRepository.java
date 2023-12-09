package br.com.theguissan.recipes.categoriareceita;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.WhereApplierInterface;
import br.com.theguissan.recipes.entity.CategoriaReceita;
import br.com.theguissan.recipes.entity.CategoriaReceita_;
import br.com.theguissan.recipes.entity.Receita_;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

@Repository
public class CategoriaReceitaRepository extends AbstractRepository<CategoriaReceita, CategoriaReceitaDto, CategoriaReceitaForm, Integer> {
    
    @Override
    public List<Selection<?>> getSelection(final Root<CategoriaReceita> from) {
        return Arrays.asList(
                from.get(CategoriaReceita_.codigo),
                from.get(CategoriaReceita_.descricao));
    }
    
    @Override
    public List<CategoriaReceitaDto> getTodos() {
        return this.getTodos(
                CategoriaReceitaDto.class,
                this::getSelection);
    }
    
    @Override
    public Optional<CategoriaReceitaDto> getPorCodigo(final Integer chave) {
        return this.getPorCodigo(
                CategoriaReceitaDto.class,
                this::getSelection,
                this.applier(chave));
    }
    
    private WhereApplierInterface<CategoriaReceita> applier(final Integer chave) {
        return (final Root<CategoriaReceita> entidade) -> {
            return Arrays.asList(this.cb().equal(entidade.get(CategoriaReceita_.codigo), chave));
        };
    }
    
    public List<CategoriaReceitaDto> buscarReceitasPorCategoria() {
        
        final CriteriaQuery<CategoriaReceitaDto> criteria = this.cb().createQuery(CategoriaReceitaDto.class);
        
        final Root<CategoriaReceita> from = criteria.from(CategoriaReceita.class);
        
        final CategoriaReceitaFromWrapper fromWrapper = new CategoriaReceitaFromWrapper(from);
        
        criteria.multiselect(this.montarCamposParaBuscarReceitasPorCategoria(fromWrapper));
        
        criteria.groupBy(from.get(CategoriaReceita_.codigo), from.get(CategoriaReceita_.descricao));
        
        criteria.orderBy(this.cb().asc(this.cb().count(fromWrapper.getJoinReceita().get(Receita_.codigo))));
        
        return this.getEntityManager().createQuery(criteria).getResultList();
        
    }
    
    private List<Selection<?>> montarCamposParaBuscarReceitasPorCategoria(final CategoriaReceitaFromWrapper from) {
        return Arrays.asList(
                from.getFrom().get(CategoriaReceita_.codigo),
                from.getFrom().get(CategoriaReceita_.descricao),
                this.cb().count(from.getJoinReceita().get(Receita_.codigo)).as(Long.class));
        
    }
    
}
