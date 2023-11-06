package br.com.theguissan.recipes.degustador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.theguissan.recipes.common.FuncionarioForm;
import br.com.theguissan.recipes.common.StandardApiInterface;

@RestController
@RequestMapping("/degustador")
public class DegustadorController implements StandardApiInterface<DegustadorDto, FuncionarioForm, Long> {
    
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
    
    @Override
    public Long insert(final FuncionarioForm form) {
        return null;
    }
    
    @Override
    public void update(final Long chave, final FuncionarioForm form) {
    
    }
    
    @Override
    public void delete(final Long chave) {
    
    }
    
}
