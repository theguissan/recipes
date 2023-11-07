package br.com.theguissan.recipes.categoriareceita;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.AbstractService;
import br.com.theguissan.recipes.common.exceptions.NotFoundException;
import br.com.theguissan.recipes.entity.CategoriaReceita;

@Service
public class CategoriaReceiteService extends AbstractService<CategoriaReceita, CategoriaReceitaDto, CategoriaReceitaForm, Integer> {
    
    @Autowired
    private CategoriaReceitaRepository categoriaReceitaRepository;
    
    protected CategoriaReceiteService(final AbstractRepository<CategoriaReceita, CategoriaReceitaDto, CategoriaReceitaForm, Integer> repository) {
        super(repository);
    }
    
    @Override
    @Transactional
    public Integer insert(final CategoriaReceitaForm form) {
        final CategoriaReceita entity = form.toEntity();
        
        this.categoriaReceitaRepository.insert(entity);
        
        return entity.getCodigo();
    }
    
    @Override
    @Transactional
    public void update(final Integer chave, final CategoriaReceitaForm form) {
        final CategoriaReceita entity = this.categoriaReceitaRepository.findById(chave);
        
        NotFoundException.lancarSe(Optional.ofNullable(entity).isEmpty(), "Categoria de receita não encontrada.");
        
        form.Fill(entity);
        
        this.categoriaReceitaRepository.merge(entity);
    }
    
    @Override
    @Transactional
    public void delete(final Integer chave) {
        this.categoriaReceitaRepository.delete(chave);
    }
    
}
