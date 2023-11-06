package br.com.theguissan.recipes.degustador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.AbstractService;
import br.com.theguissan.recipes.entity.Degustador;

@Service
public class DegustadorService extends AbstractService<Degustador, DegustadorDto, DegustadorForm, Long> {
    
    @Autowired
    private DegustadorRepository degustadorRepository;
    
    protected DegustadorService(final AbstractRepository<Degustador, DegustadorDto, DegustadorForm, Long> repository) {
        super(repository);
    }
    
    @Override
    public Long insert(final DegustadorForm form) {
        return null;
    }
    
    @Override
    public void update(final Long chave, final DegustadorForm form) {
    
    }
    
    @Override
    public void delete(final Long chave) {
    
    }
    
}
