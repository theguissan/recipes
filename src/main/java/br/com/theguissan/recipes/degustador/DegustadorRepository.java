package br.com.theguissan.recipes.degustador;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.WhereApplierInterface;
import br.com.theguissan.recipes.entity.Degustador;
import br.com.theguissan.recipes.entity.Degustador_;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

@Repository
public class DegustadorRepository extends AbstractRepository<Degustador, DegustadorDto, DegustadorForm, Long> {
    
    @Override
    public List<Selection<?>> getSelection(final Root<Degustador> from) {
        return Arrays.asList(
                from.get(Degustador_.cpf),
                from.get(Degustador_.nome),
                from.get(Degustador_.dataDoContrato),
                from.get(Degustador_.salario),
                from.get(Degustador_.ativo));
    }
    
    @Override
    public List<DegustadorDto> getTodos() {
        return this.getTodos(DegustadorDto.class, this::getSelection);
    }
    
    @Override
    public Optional<DegustadorDto> getPorCodigo(final Long chave) {
        return this.getPorCodigo(DegustadorDto.class, this::getSelection, this.applier(chave));
    }
    
    @Override
    public void insert(final Degustador entity) {
        this.insert(entity);
    }
    
    private WhereApplierInterface<Degustador> applier(final Long chave) {
        return (final Root<Degustador> entidade) -> {
            return Arrays.asList(this.cb().equal(entidade.get(Degustador_.cpf), chave));
        };
        
    }
    
}
