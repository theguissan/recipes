package br.com.theguissan.recipes.ingrediente;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.WhereApplierInterface;
import br.com.theguissan.recipes.entity.Ingrediente;
import br.com.theguissan.recipes.entity.Ingrediente_;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

@Repository
public class IngredienteRepository extends AbstractRepository<Ingrediente, IngredienteDto, IngredienteForm, Integer> {
    
    @Override
    public List<Selection<?>> getSelection(final Root<Ingrediente> from) {
        return Arrays.asList(
                from.get(Ingrediente_.codigo),
                from.get(Ingrediente_.nome),
                from.get(Ingrediente_.descricao));
    }
    
    @Override
    public List<IngredienteDto> getTodos() {
        return this.getTodos(
                IngredienteDto.class,
                this::getSelection);
    }
    
    @Override
    public Optional<IngredienteDto> getPorCodigo(final Integer chave) {
        return this.getPorCodigo(
                IngredienteDto.class,
                this::getSelection,
                this.applier(chave));
        
    }
    
    private WhereApplierInterface<Ingrediente> applier(final Integer chave) {
        return (final Root<Ingrediente> entidade) -> {
            return Arrays.asList(this.cb().equal(entidade.get(Ingrediente_.codigo), chave));
        };
    }
    
}
