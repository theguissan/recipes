package br.com.theguissan.recipes.livro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.AbstractService;
import br.com.theguissan.recipes.common.exceptions.BussinessException;
import br.com.theguissan.recipes.common.exceptions.NotFoundException;
import br.com.theguissan.recipes.editor.EditorRepository;
import br.com.theguissan.recipes.entity.Livro;

@Service
public class LivroService extends AbstractService<Livro, LivroDto, LivroForm, Integer> {
    
    @Autowired
    private LivroRepository livroRepository;
    
    @Autowired
    private EditorRepository editorRepository;
    
    protected LivroService(final AbstractRepository<Livro, LivroDto, LivroForm, Integer> repository) {
        super(repository);
    }
    
    @Override
    @Transactional
    public Integer insert(final LivroForm form) {
        
        final Optional<Livro> livro = Optional.ofNullable(this.livroRepository.findById(form.getIsbn()));
        
        if (livro.isPresent()) {
            throw new BussinessException("Livro já cadastrado");
        }
        
        final Livro entity = form.toEntity();
        
        entity.setEditor(Optional.ofNullable(this.editorRepository.findById(form.getCpfDoEditor())).orElseThrow(() -> new NotFoundException("Editor não encontrado")));
        
        this.livroRepository.insert(entity);
        
        return entity.getIsbn();
    }
    
    @Override
    @Transactional
    public void update(final Integer chave, final LivroForm form) {
        
        final Livro entity = this.livroRepository.findById(chave);
        
        form.Fill(entity);
        
        if (form.getCpfDoEditor() != null && !form.getCpfDoEditor().equals(entity.getEditor().getCpf())) {
            entity.setEditor(Optional.ofNullable(this.editorRepository.findById(form.getCpfDoEditor())).orElseThrow(() -> new NotFoundException("Editor não encontrado")));
        }
        
        this.livroRepository.merge(entity);
    }
    
    @Override
    @Transactional
    public void delete(final Integer chave) {
        this.livroRepository.delete(chave);
    }
    
}
