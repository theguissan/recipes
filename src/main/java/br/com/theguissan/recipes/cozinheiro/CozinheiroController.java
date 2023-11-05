package br.com.theguissan.recipes.cozinheiro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cozinheiro")
public class CozinheiroController {
    
    @Autowired
    private CozinheiroService cozinheiroService;
    
    @GetMapping
    public List<CozinheiroDto> getTodos() {
        return this.cozinheiroService.getTodos();
    }
    
}
