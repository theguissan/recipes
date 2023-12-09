package br.com.theguissan.recipes.cozinheiro;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.WhereApplierInterface;
import br.com.theguissan.recipes.entity.Cozinheiro;
import br.com.theguissan.recipes.entity.Cozinheiro_;
import br.com.theguissan.recipes.entity.Receita_;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

@Repository
public class CozinheiroRepository extends AbstractRepository<Cozinheiro, CozinheiroDto, CozinheiroForm, Long> {
    
    private static final int MAX_RESULTS = 5;
    
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
    
    public List<CozinheiroDto> buscarCozinheiroPorQuantidadeDeReceitas() {
        
        final CriteriaQuery<CozinheiroDto> criteria = this.cb().createQuery(CozinheiroDto.class);
        
        final Root<Cozinheiro> from = criteria.from(Cozinheiro.class);
        
        final CozinheiroFromWrapper fromWrapper = new CozinheiroFromWrapper(from);
        
        criteria.multiselect(this.montarCamposParaBuscarCozinheiroPorQuantidadeDeReceitas(fromWrapper));
        
        criteria.groupBy(fromWrapper.getFrom().get(Cozinheiro_.nome),
                         fromWrapper.getFrom().get(Cozinheiro_.nomeFantasia),
                         fromWrapper.getFrom().get(Cozinheiro_.cpf));
        
        criteria.orderBy(this.cb().asc(this.cb().count(fromWrapper.getJoinReceita().get(Receita_.codigo))));
        
        return this.getEntityManager().createQuery(criteria).setMaxResults(MAX_RESULTS).getResultList();
    }
    
    private List<Selection<?>> montarCamposParaBuscarCozinheiroPorQuantidadeDeReceitas(final CozinheiroFromWrapper from) {
        return Arrays.asList(
                from.getFrom().get(Cozinheiro_.nome),
                from.getFrom().get(Cozinheiro_.nomeFantasia),
                from.getFrom().get(Cozinheiro_.cpf),
                this.cb().count(from.getJoinReceita().get(Receita_.codigo)).as(Integer.class));
    }
    
}


