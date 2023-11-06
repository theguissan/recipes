package br.com.theguissan.recipes.degustador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.theguissan.recipes.common.AbstractService;
import br.com.theguissan.recipes.common.exceptions.BussinessException;
import br.com.theguissan.recipes.entity.Degustador;

@Service
public class DegustadorService extends AbstractService<Degustador, DegustadorDto, DegustadorForm, Long> {
    
    @Autowired
    private DegustadorRepository degustadorRepository;
    
    protected DegustadorService(final DegustadorRepository repository) {
        super(repository);
    }
    
    @Override
    @Transactional
    public Long insert(final DegustadorForm form) {
        
        final Optional<Degustador> degustador = Optional.ofNullable(this.degustadorRepository.findById(form.getCpf()));
        
        if (degustador.isPresent()) {
            throw new BussinessException("Cpf já cadastrado");
        }
        
        final Degustador entity = form.toEntity();
        
        this.degustadorRepository.insert(entity);
        
        return entity.getCpf();
    }
    
    @Override
    @Transactional
    public void update(final Long chave, final DegustadorForm form) {
        
        final Degustador entity = this.degustadorRepository.findById(chave);
        
        form.Fill(entity);
        
        this.degustadorRepository.merge(entity);
    }
    
    @Override
    @Transactional
    public void delete(final Long chave) {
        this.degustadorRepository.delete(chave);
    }
    
}
