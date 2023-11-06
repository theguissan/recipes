package br.com.theguissan.recipes.cozinheiro;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.WhereApplierInterface;
import br.com.theguissan.recipes.entity.Cozinheiro;
import br.com.theguissan.recipes.entity.Cozinheiro_;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

@Repository
public class CozinheiroRepository extends AbstractRepository<Cozinheiro, CozinheiroDto, CozinheiroForm, Long> {
    
    @Override
    public List<CozinheiroDto> getTodos() {
        return this.getTodos(CozinheiroDto.class, this::getSelection);
    }
    
    @Override
    public Optional<CozinheiroDto> getPorCodigo(final Long chave) {
        return this.getPorCodigo(
                CozinheiroDto.class,
                this::getSelection,
                this.applier(chave));
    }
    
    @Override
    public List<Selection<?>> getSelection(final Root<Cozinheiro> from) {
        return Arrays.asList(
                from.get(Cozinheiro_.cpf),
                from.get(Cozinheiro_.nome),
                from.get(Cozinheiro_.dataDoContrato),
                from.get(Cozinheiro_.salario),
                from.get(Cozinheiro_.nomeFantasia),
                from.get(Cozinheiro_.ativo));
    }
    
    private WhereApplierInterface<Cozinheiro> applier(final Long chave) {
        return (final Root<Cozinheiro> entidade) -> {
            return Arrays.asList(this.cb().equal(entidade.get(Cozinheiro_.cpf), chave));
        };
    }
    
}
