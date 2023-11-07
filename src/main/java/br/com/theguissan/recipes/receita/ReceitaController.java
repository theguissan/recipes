package br.com.theguissan.recipes.receita;

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
@RequestMapping("/receita")
public class ReceitaController implements StandardApiInterface<ReceitaDto, ReceitaForm, Integer> {
    
    @Autowired
    private ReceitaService receitaService;
    
    @Override
    @GetMapping
    public List<ReceitaDto> getTodos() {
        return this.receitaService.getTodos();
    }
    
    @Override
    @GetMapping("/{chave}")
    public ReceitaDto getPorCodigo(@PathVariable final Integer chave) {
        return this.receitaService.getPorCodigo(chave);
    }
    
    @Override
    @PostMapping
    public Integer insert(@RequestBody @Valid final ReceitaForm form) {
        return this.receitaService.insert(form);
    }
    
    @Override
    @PutMapping("/{chave}")
    public void update(@PathVariable final Integer chave, @RequestBody final ReceitaForm form) {
        this.receitaService.update(chave, form);
    }
    
    @Override
    @DeleteMapping("/{chave}")
    public void delete(@PathVariable final Integer chave) {
        this.receitaService.delete(chave);
    }
    
}
