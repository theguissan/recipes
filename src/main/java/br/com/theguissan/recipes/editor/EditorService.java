package br.com.theguissan.recipes.editor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.theguissan.recipes.common.AbstractService;
import br.com.theguissan.recipes.common.exceptions.BussinessException;
import br.com.theguissan.recipes.entity.Editor;

@Service
public class EditorService extends AbstractService<Editor, EditorDto, EditorForm, Long> {
    
    @Autowired
    private EditorRepository editorRepository;
    
    protected EditorService(final EditorRepository repository) {
        super(repository);
    }
    
    @Override
    @Transactional
    public Long insert(final EditorForm form) {
        
        final Optional<Editor> editor = Optional.ofNullable(this.editorRepository.findById(form.getCpf()));
        
        if (editor.isPresent()) {
            throw new BussinessException("Cpf já cadastrado");
        }
        
        final Editor entity = form.toEntity();
        
        this.editorRepository.insert(entity);
        
        return entity.getCpf();
    }
    
    @Override
    @Transactional
    public void update(final Long chave, final EditorForm form) {
        
        final Editor entity = this.editorRepository.findById(chave);
        
        form.Fill(entity);
        
        this.editorRepository.merge(entity);
    }
    
    @Override
    @Transactional
    public void delete(final Long chave) {
        this.editorRepository.delete(chave);
    }
    
}
