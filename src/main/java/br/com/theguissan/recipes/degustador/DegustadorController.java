package br.com.theguissan.recipes.degustador;

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

import br.com.theguissan.recipes.common.FuncionarioForm;
import br.com.theguissan.recipes.common.StandardApiInterface;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/degustador")
public class DegustadorController implements StandardApiInterface<DegustadorDto, DegustadorForm, Long> {
    
    @Autowired
    private DegustadorService degustadorService;
    
    @Override
    @GetMapping
    public List<DegustadorDto> getTodos() {
        return this.degustadorService.getTodos();
    }
    
    @GetMapping("/{chave}")
    @Override
    public DegustadorDto getPorCodigo(@PathVariable final Long chave) {
        return this.degustadorService.getPorCodigo(chave);
    }
    
    @PostMapping
    @Override
    public Long insert( @RequestBody @Valid final DegustadorForm form) {
        return this.degustadorService.insert(form);
    }
    
    @PutMapping("/{chave}")
    @Override
    public void update( @PathVariable final Long chave, @RequestBody  final DegustadorForm form) {
        this.degustadorService.update(chave, form);
    }
    
    @DeleteMapping("/{chave}")
    @Override
    public void delete( @PathVariable final Long chave) {
        this.degustadorService.delete(chave);
    }
    
}
