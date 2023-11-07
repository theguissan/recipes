package br.com.theguissan.recipes.restaurantecozinheiro;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.WhereApplierInterface;
import br.com.theguissan.recipes.entity.Funcionario_;
import br.com.theguissan.recipes.entity.RestauranteCozinheiro;
import br.com.theguissan.recipes.entity.RestauranteCozinheiroId;
import br.com.theguissan.recipes.entity.RestauranteCozinheiroId_;
import br.com.theguissan.recipes.entity.RestauranteCozinheiro_;
import br.com.theguissan.recipes.entity.Restaurante_;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

@Repository
public class RestauranteCozinheiroRepository extends AbstractRepository<RestauranteCozinheiro, RestauranteCozinheiroDto, RestauranteCozinheiroForm, RestauranteCozinheiroId> {
    
    @Override
    public List<Selection<?>> getSelection(final Root<RestauranteCozinheiro> from) {
        return Arrays.asList(
                from.get(RestauranteCozinheiro_.codigo)
                    .get(RestauranteCozinheiroId_.restaurante)
                    .get(Restaurante_.codigo),
                from.get(RestauranteCozinheiro_.codigo)
                    .get(RestauranteCozinheiroId_.restaurante)
                    .get(Restaurante_.nome),
                from.get(RestauranteCozinheiro_.codigo)
                    .get(RestauranteCozinheiroId_.cozinheiro)
                    .get(Funcionario_.cpf),
                from.get(RestauranteCozinheiro_.codigo)
                    .get(RestauranteCozinheiroId_.cozinheiro)
                    .get(Funcionario_.nome),
                from.get(RestauranteCozinheiro_.dataDeContratacao));
    }
    
    @Override
    public List<RestauranteCozinheiroDto> getTodos() {
        return this.getTodos(
                RestauranteCozinheiroDto.class,
                this::getSelection);
    }
    
    @Override
    public Optional<RestauranteCozinheiroDto> getPorCodigo(final RestauranteCozinheiroId chave) {
        return this.getPorCodigo(
                RestauranteCozinheiroDto.class,
                this::getSelection,
                this.applier(chave));
        
    }
    
    private WhereApplierInterface<RestauranteCozinheiro> applier(final RestauranteCozinheiroId chave) {
        return (final Root<RestauranteCozinheiro> entidade) -> {
            return Arrays.asList(this.cb().equal(entidade.get(RestauranteCozinheiro_.codigo), chave));
        };
    }
    
}
