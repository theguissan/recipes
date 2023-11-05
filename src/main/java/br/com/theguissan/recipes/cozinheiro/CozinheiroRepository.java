package br.com.theguissan.recipes.cozinheiro;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.BaseRepository;
import br.com.theguissan.recipes.entity.Cozinheiro;
import br.com.theguissan.recipes.entity.Cozinheiro_;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

@Repository
public class CozinheiroRepository extends BaseRepository {
    
    public List<CozinheiroDto> getTodos() {
        
        final CriteriaQuery<CozinheiroDto> criteria = this.cb().createQuery(CozinheiroDto.class);
        
        final Root<Cozinheiro> from = criteria.from(Cozinheiro.class);
        
        criteria.multiselect(this.getSelecoes(from));
        
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
    
    private List<Selection<?>> getSelecoes(final Root<Cozinheiro> from) {
        
        return Arrays.asList(
                from.get(Cozinheiro_.cpf),
                from.get(Cozinheiro_.nome),
                from.get(Cozinheiro_.dataDoContrato),
                from.get(Cozinheiro_.salario),
                from.get(Cozinheiro_.nomeFantasia),
                from.get(Cozinheiro_.ativo)
                            
                            );
    }
    
}
