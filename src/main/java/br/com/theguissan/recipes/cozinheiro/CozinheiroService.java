package br.com.theguissan.recipes.cozinheiro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CozinheiroService {
    
    @Autowired
    private CozinheiroRepository cozinheiroRepository;
    
    @Transactional(readOnly = true)
    public List<CozinheiroDto> getTodos() {
        return this.cozinheiroRepository.getTodos();
    }
    
}
