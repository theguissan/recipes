package br.com.theguissan.recipes.editor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.theguissan.recipes.common.StandardApiInterface;

@RestController
@RequestMapping("/editor")
public class EditorController implements StandardApiInterface<EditorDto, EditorForm, Long> {
    
    @Autowired
    private EditorService editorService;
    
    @Override
    @GetMapping
    public List<EditorDto> getTodos() {
        return this.editorService.getTodos();
    }
    
    @Override
    @GetMapping("/{chave}")
    public EditorDto getPorCodigo(@PathVariable final Long chave) {
        return this.editorService.getPorCodigo(chave);
    }
    
    @Override
    @PostMapping
    public Long insert(@RequestBody final EditorForm form) {
        return this.editorService.insert(form);
    }
    
    @Override
    @PutMapping("/{chave}")
    public void update(@PathVariable final Long chave, @RequestBody final EditorForm form) {
        this.editorService.update(chave, form);
    }
    
    @Override
    @DeleteMapping("/{chave}")
    public void delete(@PathVariable final Long chave) {
        this.editorService.delete(chave);
    }
    
}
