package br.com.theguissan.recipes.restaurante;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.WhereApplierInterface;
import br.com.theguissan.recipes.entity.Restaurante;
import br.com.theguissan.recipes.entity.Restaurante_;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

@Repository
public class RestauranteRepository extends AbstractRepository<Restaurante, RestauranteDto, RestauranteForm, Integer> {
    
    @Override
    public List<Selection<?>> getSelection(final Root<Restaurante> from) {
        return Arrays.asList(
                from.get(Restaurante_.codigo),
                from.get(Restaurante_.nome));
    }
    
    @Override
    public List<RestauranteDto> getTodos() {
        return this.getTodos(
                RestauranteDto.class,
                this::getSelection);
    }
    
    @Override
    public Optional<RestauranteDto> getPorCodigo(final Integer chave) {
        return this.getPorCodigo(
                RestauranteDto.class,
                this::getSelection,
                this.applier(chave));
    }
    
    private WhereApplierInterface<Restaurante> applier(final Integer chave) {
        return (final Root<Restaurante> entidade) -> {
            return Arrays.asList(this.cb().equal(entidade.get(Restaurante_.codigo), chave));
        };
    }
    
}
