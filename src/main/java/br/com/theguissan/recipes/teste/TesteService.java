package br.com.theguissan.recipes.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.theguissan.recipes.degustador.DegustadorRepository;
import br.com.theguissan.recipes.entity.TesteId;

@Service
public class TesteService {
    
    @Autowired
    private TesteRepository testeRepository;
    
    @Autowired
    private DegustadorRepository degustadorRepository;
    
    @Transactional
    public TesteIdForm insert(final TesteForm form) {
        
        return null;
        
    }
    
    @Transactional
    public void delete(final TesteIdForm chave) {
        
    }
    
    @Transactional(readOnly = true)
    public List<TesteDto> getTodos() {
        return null;
    }
    
    @Transactional(readOnly = true)
    public TesteDto getPorCodigo(final TesteIdForm chave) {
        return null;
    }
    
    private TesteId getRestauranteCozinheiroId(final TesteIdForm chave) {
        
        return null;
    }
    
}
