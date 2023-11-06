package br.com.theguissan.recipes.ingrediente;

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
@RequestMapping("/ingrediente")
public class IngredienteController implements StandardApiInterface<IngredienteDto, IngredienteForm, Integer> {
    
    @Autowired
    private IngredienteService ingredienteService;
    
    @Override
    @GetMapping
    public List<IngredienteDto> getTodos() {
        return this.ingredienteService.getTodos();
    }
    
    @Override
    @GetMapping("/{chave}")
    public IngredienteDto getPorCodigo(@PathVariable final Integer chave) {
        return this.ingredienteService.getPorCodigo(chave);
    }
    
    @Override
    @PostMapping
    public Integer insert(@RequestBody @Valid final IngredienteForm form) {
        return this.ingredienteService.insert(form);
    }
    
    @Override
    @PutMapping("/{chave}")
    public void update(@PathVariable final Integer chave, @RequestBody final IngredienteForm form) {
        this.ingredienteService.update(chave, form);
    }
    
    @Override
    @DeleteMapping("/{chave}")
    public void delete(@PathVariable final Integer chave) {
        this.ingredienteService.delete(chave);
    }
    
}
