package br.com.theguissan.recipes.receita;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.theguissan.recipes.categoriareceita.CategoriaReceitaRepository;
import br.com.theguissan.recipes.common.AbstractRepository;
import br.com.theguissan.recipes.common.AbstractService;
import br.com.theguissan.recipes.common.exceptions.BussinessException;
import br.com.theguissan.recipes.common.exceptions.NotFoundException;
import br.com.theguissan.recipes.cozinheiro.CozinheiroRepository;
import br.com.theguissan.recipes.entity.Receita;
import br.com.theguissan.recipes.livro.LivroRepository;

@Service
public class ReceitaService extends AbstractService<Receita, ReceitaDto, ReceitaForm, Integer> {
    
    @Autowired
    private ReceitaRepository receitaRepository;
    
    @Autowired
    private CozinheiroRepository cozinheiroRepository;
    
    @Autowired
    private LivroRepository livroRepository;
    
    @Autowired
    private CategoriaReceitaRepository categoriaReceitaRepository;
    
    protected ReceitaService(final AbstractRepository<Receita, ReceitaDto, ReceitaForm, Integer> repository) {
        super(repository);
    }
    
    @Override
    @Transactional
    public Integer insert(final ReceitaForm form) {
        
        final Receita entity = form.toEntity();
        
        entity.setCozinheiro(
                Optional.ofNullable(this.cozinheiroRepository.findById(form.getCpfDoCozinheiro()))
                        .orElseThrow(() -> new NotFoundException("Cozinheiro não encontrado")));
        
        if (this.receitaRepository.buscarQuantidadeDeReceitasDeCozinheiro(form.getCpfDoCozinheiro()) == 0) {
            BussinessException.lancarSe(entity.getDataDeCriacao().isAfter(entity.getCozinheiro().getDataDoContrato().plusDays(45)),
                                        "Um cozinheiro recém-contratado tem até 45 dias para entregar sua primeira receita. Após esse período, não é permitido.");
        }
        
        entity.setLivro(
                Optional.ofNullable(this.livroRepository.findById(form.getIsbnDoLivro()))
                        .orElseThrow(() -> new NotFoundException("Livro não encontrado")));
        
        entity.setCategoriaReceita(
                Optional.ofNullable(this.categoriaReceitaRepository.findById(form.getCodigoDaCategoria()))
                        .orElseThrow(() -> new NotFoundException("Categoria não encontrada")));
        
        this.receitaRepository.insert(entity);
        
        return entity.getCodigo();
    }
    
    @Override
    @Transactional
    public void update(final Integer chave, final ReceitaForm form) {
        
        final Receita entity = this.receitaRepository.findById(chave);
        
        NotFoundException.lancarSe(Optional.ofNullable(entity).isEmpty(), "Receita não encontrada");
        
        form.Fill(entity);
        
        this.receitaRepository.merge(entity);
    }
    
    @Override
    @Transactional
    public void delete(final Integer chave) {
        this.receitaRepository.delete(chave);
    }
    
}
