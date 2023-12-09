package br.com.theguissan.recipes.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {
    
    @Autowired
    private TesteService testeService;
    
    @CrossOrigin
    @PostMapping
    public List<TesteDto> buscarTeste(@RequestBody final TesteForm form) {
        return this.testeService.buscarTeste(form);
    }
    
}
