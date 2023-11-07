package br.com.theguissan.recipes.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.AbstractService;
import br.com.theguissan.recipes.entity.Restaurante;

@Service
public class RestauranteService extends AbstractService<Restaurante, RestauranteDto, RestauranteForm, Integer> {
    
    @Autowired
    private RestauranteRepository restauranteRepository;
    
    protected RestauranteService(final AbstractRepository<Restaurante, RestauranteDto, RestauranteForm, Integer> repository) {
        super(repository);
    }
    
    @Override
    @Transactional
    public Integer insert(final RestauranteForm form) {
        final Restaurante entity = form.toEntity();
        
        this.restauranteRepository.insert(entity);
        
        return entity.getCodigo();
    }
    
    @Override
    @Transactional
    public void update(final Integer chave, final RestauranteForm form) {
        
        final Restaurante entity = this.restauranteRepository.findById(chave);
        
        form.Fill(entity);
        
        this.restauranteRepository.merge(entity);
    }
    
    @Override
    @Transactional
    public void delete(final Integer chave) {
        this.restauranteRepository.delete(chave);
    }
    
}
