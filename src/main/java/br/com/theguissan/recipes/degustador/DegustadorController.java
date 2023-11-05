package br.com.theguissan.recipes.degustador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.theguissan.recipes.entity.Degustador;

@RestController
@RequestMapping("/degustador")
public class DegustadorController {
    
    @Autowired
    private DegustadorService degustadorService;
    
    @GetMapping
    public List<DegustadorDto> getTodos() {
        return this.degustadorService.getTodos(DegustadorDto.class, Degustador.class);
    }
    
}
