package br.com.theguissan.recipes.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TesteService {
    
    @Autowired
    private TesteRepository testeRepository;
    
    @Transactional(readOnly = true)
    public List<TesteDto> buscarTeste(final TesteForm form) {
        return this.testeRepository.buscarTeste(form);
    }
    
}
