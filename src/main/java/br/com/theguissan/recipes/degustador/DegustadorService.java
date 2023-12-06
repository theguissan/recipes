package br.com.theguissan.recipes.degustador;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.theguissan.recipes.common.AbstractService;
import br.com.theguissan.recipes.common.exceptions.BussinessException;
import br.com.theguissan.recipes.common.exceptions.NotFoundException;
import br.com.theguissan.recipes.entity.Degustador;
import br.com.theguissan.recipes.entity.Funcionario;
import br.com.theguissan.recipes.funcionario.FuncionarioRepository;

@Service
public class DegustadorService extends AbstractService<Degustador, DegustadorDto, DegustadorForm, Long> {
    
    @Autowired
    private DegustadorRepository degustadorRepository;
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
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
        
        final Funcionario funcionario = this.funcionarioRepository.findById(form.getCpf());
        
        if (Objects.nonNull(funcionario)) {
            this.funcionarioRepository.insert(form.toFuncionarioEntity());
        }
        
        final Degustador entity = form.toEntity();
        
        this.funcionarioRepository.insert(funcionario);
        
        this.degustadorRepository.insert(entity);
        
        return entity.getCpf();
    }
    
    @Override
    @Transactional
    public void update(final Long chave, final DegustadorForm form) {
        
        final Degustador entity = this.degustadorRepository.findById(chave);
        
        NotFoundException.lancarSe(Optional.ofNullable(entity).isEmpty(), "Degustador não encontrado");
        
        form.Fill(entity);
        
        final Funcionario funcionario = this.funcionarioRepository.findById(chave);
        
        NotFoundException.lancarSe(Optional.ofNullable(funcionario).isEmpty(), "Funcionario não encontrado");
        
        form.fillFuncionario(funcionario);
        
        this.funcionarioRepository.merge(funcionario);
        
        this.degustadorRepository.merge(entity);
    }
    
    @Override
    @Transactional
    public void delete(final Long chave) {
        this.degustadorRepository.delete(chave);
        this.funcionarioRepository.delete(chave);
    }
    
    @Transactional(readOnly = true)
    public List<DegustadorDto> getMaioresDegustadores(final DegustadorForm degustador) {
        return this.getTodos();
    }
    
}
