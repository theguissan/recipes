package br.com.theguissan.recipes.cozinheiro;

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
@RequestMapping("/cozinheiro")
public class CozinheiroController implements StandardApiInterface<CozinheiroDto, CozinheiroForm, Long> {
    
    @Autowired
    private CozinheiroService cozinheiroService;
    
    @GetMapping
    public List<CozinheiroDto> getTodos() {
        return this.cozinheiroService.getTodos();
    }
    
    @GetMapping("/{chave}")
    @Override
    public CozinheiroDto getPorCodigo(@PathVariable final Long chave) {
        return this.cozinheiroService.getPorCodigo(chave);
    }
    
    @PostMapping
    @Override
    public Long insert(@RequestBody @Valid final CozinheiroForm form) {
        return this.cozinheiroService.insert(form);
    }
    
    @PutMapping("/{chave}")
    @Override
    public void update(@PathVariable final Long chave, @RequestBody final CozinheiroForm form) {
        this.cozinheiroService.update(chave, form);
    }
    
    @DeleteMapping("/{chave}")
    @Override
    public void delete(@PathVariable final Long chave) {
        this.cozinheiroService.delete(chave);
    }
    
}
