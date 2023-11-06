package br.com.theguissan.recipes.cozinheiro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.AbstractService;
import br.com.theguissan.recipes.common.exceptions.BussinessException;
import br.com.theguissan.recipes.entity.Cozinheiro;

@Service
public class CozinheiroService extends AbstractService<Cozinheiro, CozinheiroDto, CozinheiroForm, Long> {
    
    @Autowired
    private CozinheiroRepository cozinheiroRepository;
    
    protected CozinheiroService(final AbstractRepository<Cozinheiro, CozinheiroDto, CozinheiroForm, Long> repository) {
        super(repository);
    }
    
    @Override
    @Transactional
    public Long insert(final CozinheiroForm form) {
        
        final Optional<Cozinheiro> cozinheiro = Optional.ofNullable(this.cozinheiroRepository.findById(form.getCpf()));
        
        if (cozinheiro.isPresent()) {
            throw new BussinessException("Cpf já cadastrado");
        }
        
        final Cozinheiro entity = form.toEntity();
        
        this.cozinheiroRepository.insert(entity);
        
        return entity.getCpf();
    }
    
    @Override
    @Transactional
    public void update(final Long chave, final CozinheiroForm form) {
        
        final Cozinheiro entity = this.cozinheiroRepository.findById(chave);
        
        form.Fill(entity);
        
        this.cozinheiroRepository.merge(entity);
    }
    
    @Override
    @Transactional
    public void delete(final Long chave) {
        this.cozinheiroRepository.delete(chave);
    }
    
}
