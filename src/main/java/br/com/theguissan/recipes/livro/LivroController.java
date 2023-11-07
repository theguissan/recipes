package br.com.theguissan.recipes.livro;

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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController implements StandardApiInterface<LivroDto, LivroForm, Integer> {
    
    @Autowired
    private LivroService livroService;
    
    @Override
    @GetMapping
    public List<LivroDto> getTodos() {
        return this.livroService.getTodos();
    }
    
    @Override
    @GetMapping("/{chave}")
    public LivroDto getPorCodigo(@PathVariable final Integer chave) {
        return this.livroService.getPorCodigo(chave);
    }
    
    @Override
    @PostMapping
    public Integer insert(@RequestBody @Valid final LivroForm form) {
        return this.livroService.insert(form);
    }
    
    @Override
    @PutMapping("/{chave}")
    public void update(@PathVariable final Integer chave, @RequestBody final LivroForm form) {
        this.livroService.update(chave, form);
    }
    
    @Override
    @DeleteMapping("/{chave}")
    public void delete(@PathVariable final Integer chave) {
        this.livroService.delete(chave);
    }
    
}
