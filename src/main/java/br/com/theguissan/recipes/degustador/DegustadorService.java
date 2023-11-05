package br.com.theguissan.recipes.degustador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.AbstractService;
import br.com.theguissan.recipes.entity.Degustador;

@Service
public class DegustadorService extends AbstractService<DegustadorDto, Degustador> {
    
    @Autowired
    private DegustadorRepository degustadorRepository;
    
    protected DegustadorService(final AbstractRepository<DegustadorDto, Degustador> repository) {
        super(repository);
    }
    
}
