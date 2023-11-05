package br.com.theguissan.recipes.degustador;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.entity.Degustador;
import br.com.theguissan.recipes.entity.Degustador_;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

@Repository
public class DegustadorRepository extends AbstractRepository<DegustadorDto, Degustador> {
    
    @Override
    public List<Selection<?>> getSelection(final Root<Degustador> from) {
        return Arrays.asList(
                from.get(Degustador_.cpf),
                from.get(Degustador_.nome),
                from.get(Degustador_.dataDoContrato),
                from.get(Degustador_.salario),
                from.get(Degustador_.ativo));
    }
    
}
