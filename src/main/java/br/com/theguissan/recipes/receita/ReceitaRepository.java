package br.com.theguissan.recipes.receita;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.WhereApplierInterface;
import br.com.theguissan.recipes.entity.CategoriaReceita_;
import br.com.theguissan.recipes.entity.Cozinheiro_;
import br.com.theguissan.recipes.entity.Livro_;
import br.com.theguissan.recipes.entity.Receita;
import br.com.theguissan.recipes.entity.Receita_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

@Repository
public class ReceitaRepository extends AbstractRepository<Receita, ReceitaDto, ReceitaForm, Integer> {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Selection<?>> getSelection(final Root<Receita> from) {
        return Arrays.asList(
                from.get(Receita_.codigo),
                from.get(Receita_.nome),
                from.get(Receita_.dataDeCriacao),
                from.get(Receita_.cozinheiro).get(Cozinheiro_.cpf),
                from.get(Receita_.cozinheiro).get(Cozinheiro_.nome),
                from.get(Receita_.livro).get(Livro_.isbn),
                from.get(Receita_.livro).get(Livro_.titulo),
                from.get(Receita_.categoriaReceita).get(CategoriaReceita_.descricao),
                from.get(Receita_.descricao),
                from.get(Receita_.porcoes));
    }
    
    @Override
    public List<ReceitaDto> getTodos() {
        return this.getTodos(
                ReceitaDto.class,
                this::getSelection);
    }
    
    @Override
    public Optional<ReceitaDto> getPorCodigo(final Integer chave) {
        return this.getPorCodigo(
                ReceitaDto.class,
                this::getSelection,
                this.applier(chave));
    }
    
    private WhereApplierInterface<Receita> applier(final Integer chave) {
        return (final Root<Receita> entidade) -> {
            return Arrays.asList(this.cb().equal(entidade.get(Receita_.codigo), chave));
        };
    }
    
    public Integer buscarQuantidadeDeReceitasDeCozinheiro(final Long cpfDoCozinheiro) {
        final CriteriaQuery<Integer> criteria = this.cb().createQuery(Integer.class);
        
        final Root<Receita> from = criteria.from(Receita.class);
        
        criteria.select(this.cb().count(from).as(Integer.class));
        
        criteria.where(this.cb().equal(from.get(Receita_.cozinheiro).get(Cozinheiro_.cpf), cpfDoCozinheiro));
        
        return this.entityManager.createQuery(criteria).getSingleResult();
    }
    
    public Optional<Integer> isTituloDeReceitaJaPublicadaPorCozinheiro(final Long cpfDoCozinheiro, final String titulo) {
        
        final CriteriaQuery<Integer> criteria = this.cb().createQuery(Integer.class);
        
        final Root<Receita> from = criteria.from(Receita.class);
        
        criteria.select(from.get(Receita_.codigo));
        
        criteria.where(
                this.cb().equal(from.get(Receita_.cozinheiro).get(Cozinheiro_.cpf), cpfDoCozinheiro),
                this.cb().equal(from.get(Receita_.nome), titulo));
        
        try {
            
            return Optional.of(this.entityManager.createQuery(criteria).getSingleResult());
        } catch (final NoResultException e) {
            return Optional.empty();
        }
        
    }
    
}
