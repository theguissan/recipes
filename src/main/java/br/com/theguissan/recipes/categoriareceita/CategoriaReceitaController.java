package br.com.theguissan.recipes.categoriareceita;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/categoria-receita")
public class CategoriaReceitaController implements StandardApiInterface<CategoriaReceitaDto, CategoriaReceitaForm, Integer> {
    
    @Autowired
    private CategoriaReceiteService categoriaReceitaService;
    
    @Override
    @GetMapping
    public List<CategoriaReceitaDto> getTodos() {
        return this.categoriaReceitaService.getTodos();
    }
    
    @Override
    @GetMapping("/{chave}")
    public CategoriaReceitaDto getPorCodigo(@PathVariable final Integer chave) {
        return this.categoriaReceitaService.getPorCodigo(chave);
    }
    
    @Override
    @PostMapping
    public Integer insert(@RequestBody @Valid final CategoriaReceitaForm form) {
        return this.categoriaReceitaService.insert(form);
    }
    
    @Override
    @PutMapping("/{chave}")
    public void update(@PathVariable final Integer chave, @RequestBody final CategoriaReceitaForm form) {
        this.categoriaReceitaService.update(chave, form);
    }
    
    @Override
    @DeleteMapping("/{chave}")
    public void delete(@PathVariable final Integer chave) {
        this.categoriaReceitaService.delete(chave);
    }
    
    @CrossOrigin
    @GetMapping("/por-categoria")
    public List<CategoriaReceitaDto> buscarReceitasPorCategoria() {
        return this.categoriaReceitaService.buscarReceitasPorCategoria();
    }
    
}
