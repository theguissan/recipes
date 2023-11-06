package br.com.theguissan.recipes.livro;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.WhereApplierInterface;
import br.com.theguissan.recipes.entity.Editor_;
import br.com.theguissan.recipes.entity.Livro;
import br.com.theguissan.recipes.entity.Livro_;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

@Repository
public class LivroRepository extends AbstractRepository<Livro, LivroDto, LivroForm, Integer> {
    
    @Override
    public List<Selection<?>> getSelection(final Root<Livro> from) {
        return Arrays.asList(
                from.get(Livro_.isbn),
                from.get(Livro_.titulo),
                from.get(Livro_.editor).get(Editor_.nome));
    }
    
    @Override
    public List<LivroDto> getTodos() {
        return this.getTodos(LivroDto.class, this::getSelection);
    }
    
    @Override
    public Optional<LivroDto> getPorCodigo(final Integer chave) {
        return this.getPorCodigo(
                LivroDto.class,
                this::getSelection,
                this.applier(chave));
    }
    
    private WhereApplierInterface<Livro> applier(final Integer chave) {
        return (final Root<Livro> entidade) -> {
            return Arrays.asList(this.cb().equal(entidade.get(Livro_.isbn), chave));
        };
    }
    
}
