package br.com.theguissan.recipes.restaurante;

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
@RequestMapping("/restaurante")
public class RestauranteController implements StandardApiInterface<RestauranteDto, RestauranteForm, Integer> {
    
    @Autowired
    private RestauranteService restauranteService;
    
    @Override
    @GetMapping
    public List<RestauranteDto> getTodos() {
        return this.restauranteService.getTodos();
    }
    
    @Override
    @GetMapping("/{chave}")
    public RestauranteDto getPorCodigo(@PathVariable final Integer chave) {
        return this.restauranteService.getPorCodigo(chave);
    }
    
    @Override
    @PostMapping
    public Integer insert(@RequestBody @Valid final RestauranteForm form) {
        return this.restauranteService.insert(form);
    }
    
    @Override
    @PutMapping("/{chave}")
    public void update(@PathVariable final Integer chave, @RequestBody final RestauranteForm form) {
        this.restauranteService.update(chave, form);
        
    }
    
    @Override
    @DeleteMapping("/{chave}")
    public void delete(@PathVariable final Integer chave) {
        this.restauranteService.delete(chave);
    }
    
}
