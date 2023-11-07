package br.com.theguissan.recipes.restaurantecozinheiro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.theguissan.recipes.common.exceptions.BussinessException;
import br.com.theguissan.recipes.common.exceptions.NotFoundException;
import br.com.theguissan.recipes.cozinheiro.CozinheiroRepository;
import br.com.theguissan.recipes.entity.Cozinheiro;
import br.com.theguissan.recipes.entity.Restaurante;
import br.com.theguissan.recipes.entity.RestauranteCozinheiro;
import br.com.theguissan.recipes.entity.RestauranteCozinheiroId;
import br.com.theguissan.recipes.restaurante.RestauranteRepository;

@Service
public class RestauranteCozinheiroService {
    
    @Autowired
    private RestauranteCozinheiroRepository restauranteCozinheiroRepository;
    
    @Autowired
    private CozinheiroRepository cozinheiroRepository;
    
    @Autowired
    private RestauranteRepository restauranteRepository;
    
    @Transactional
    public RestauranteCozinheiroIdForm insert(final RestauranteCozinheiroForm form) {
        
        final Optional<RestauranteCozinheiro> restauranteCozinheiro = Optional.ofNullable(this.restauranteCozinheiroRepository.findById(this.getRestauranteCozinheiroId(form.getCodigos())));
        
        BussinessException.lancarSe(restauranteCozinheiro.isPresent(), "Restaurante e Cozinheiro já cadastrados");
        
        final RestauranteCozinheiro entity = form.toEntity();
        
        entity.setCodigo(this.getRestauranteCozinheiroId(form.getCodigos()));
        
        this.restauranteCozinheiroRepository.insert(entity);
        
        return form.getCodigos();
    }
    
    @Transactional
    public void delete(final RestauranteCozinheiroIdForm chave) {
        
        final Optional<RestauranteCozinheiro> restauranteCozinheiro = Optional.ofNullable(this.restauranteCozinheiroRepository.findById(this.getRestauranteCozinheiroId(chave)));
        
        NotFoundException.lancarSe(!restauranteCozinheiro.isPresent(), "Restaurante e Cozinheiro não cadastrados");
        
        this.restauranteCozinheiroRepository.delete(this.getRestauranteCozinheiroId(chave));
    }
    
    @Transactional(readOnly = true)
    public List<RestauranteCozinheiroDto> getTodos() {
        return this.restauranteCozinheiroRepository.getTodos();
    }
    
    @Transactional(readOnly = true)
    public RestauranteCozinheiroDto getPorCodigo(final RestauranteCozinheiroIdForm chave) {
        return this.restauranteCozinheiroRepository.getPorCodigo(this.getRestauranteCozinheiroId(chave)).orElseThrow(() -> new NotFoundException("Dado não encontrado"));
    }
    
    private RestauranteCozinheiroId getRestauranteCozinheiroId(final RestauranteCozinheiroIdForm chave) {
        final Optional<Cozinheiro> cozinheiro = Optional.ofNullable(this.cozinheiroRepository.findById(chave.getCpfDoCozinheiro()));
        
        final Optional<Restaurante> restaurante = Optional.ofNullable(this.restauranteRepository.findById(chave.getCodigoDoRestaurante()));
        
        NotFoundException.lancarSe(!cozinheiro.isPresent() || !restaurante.isPresent(), "Cozinheiro ou Restaurante não encontrado");
        
        final RestauranteCozinheiroId id = new RestauranteCozinheiroId();
        
        id.setCozinheiro(cozinheiro.get());
        
        id.setRestaurante(restaurante.get());
        
        return id;
    }
    
}
