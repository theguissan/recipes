package br.com.theguissan.recipes.teste;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teste")
public class TesteController {
    
    private TesteService testeService;
    
    @GetMapping
    public List<TesteDto> getTodos() {
        return this.testeService.getTodos();
    }
    
    @PostMapping("/by-id")
    public TesteDto getPorCodigo(@RequestBody @Valid final TesteIdForm chave) {
        return this.testeService.getPorCodigo(chave);
    }
    
    @PostMapping
    public TesteIdForm insert(@RequestBody @Valid final TesteForm form) {
        return this.testeService.insert(form);
    }
    
    @PostMapping("/delete")
    public void delete(@RequestBody @Valid final TesteIdForm chave) {
        this.testeService.delete(chave);
    }
    
}
