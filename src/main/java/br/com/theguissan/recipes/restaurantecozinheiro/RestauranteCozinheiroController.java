package br.com.theguissan.recipes.restaurantecozinheiro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/restaurante-cozinheiro")
public class RestauranteCozinheiroController {
    
    @Autowired
    private RestauranteCozinheiroService restauranteCozinheiroService;
    
    @GetMapping
    public List<RestauranteCozinheiroDto> getTodos() {
        return this.restauranteCozinheiroService.getTodos();
    }
    
    @PostMapping("/by-id")
    public RestauranteCozinheiroDto getPorCodigo(@RequestBody @Valid final RestauranteCozinheiroIdForm chave) {
        return this.restauranteCozinheiroService.getPorCodigo(chave);
    }
    
    @PostMapping
    public RestauranteCozinheiroIdForm insert(@RequestBody @Valid final RestauranteCozinheiroForm form) {
        return this.restauranteCozinheiroService.insert(form);
    }
    
    @PostMapping("/delete")
    public void delete(@RequestBody @Valid final RestauranteCozinheiroIdForm chave) {
        this.restauranteCozinheiroService.delete(chave);
    }
    
}
