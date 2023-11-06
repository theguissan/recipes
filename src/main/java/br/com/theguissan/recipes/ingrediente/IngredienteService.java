package br.com.theguissan.recipes.ingrediente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.AbstractService;
import br.com.theguissan.recipes.entity.Ingrediente;

@Service
public class IngredienteService extends AbstractService<Ingrediente, IngredienteDto, IngredienteForm, Integer> {
    
    @Autowired
    private IngredienteRepository ingredienteRepository;
    
    protected IngredienteService(final AbstractRepository<Ingrediente, IngredienteDto, IngredienteForm, Integer> repository) {
        super(repository);
    }
    
    @Override
    @Transactional
    public Integer insert(final IngredienteForm form) {
        final Ingrediente entity = form.toEntity();
        
        this.ingredienteRepository.insert(entity);
        
        return entity.getCodigo();
    }
    
    @Override
    @Transactional
    public void update(final Integer chave, final IngredienteForm form) {
        
        final Ingrediente entity = this.ingredienteRepository.findById(chave);
        
        form.Fill(entity);
        
        this.ingredienteRepository.merge(entity);
        
    }
    
    @Override
    @Transactional
    public void delete(final Integer chave) {
        this.ingredienteRepository.delete(chave);
    }
    
}
