package br.com.theguissan.recipes.editor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.WhereApplierInterface;
import br.com.theguissan.recipes.entity.Editor;
import br.com.theguissan.recipes.entity.Editor_;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

@Repository
public class EditorRepository extends AbstractRepository<Editor, EditorDto, EditorForm, Long> {
    
    @Override
    public List<Selection<?>> getSelection(Root<Editor> from) {
        return Arrays.asList(
                from.get(Editor_.cpf),
                from.get(Editor_.nome),
                from.get(Editor_.dataDoContrato),
                from.get(Editor_.salario),
                from.get(Editor_.ativo));
    }
    
    @Override
    public List<EditorDto> getTodos() {
        return this.getTodos(EditorDto.class, this::getSelection);
    }
    
    @Override
    public Optional<EditorDto> getPorCodigo(Long chave) {
        return this.getPorCodigo(EditorDto.class, this::getSelection, this.applier(chave));
    }
    
    private WhereApplierInterface<Editor> applier(final Long chave) {
        return (final Root<Editor> entidade) -> {
            return Arrays.asList(this.cb().equal(entidade.get(Editor_.cpf), chave));
        };
    }
    
}
