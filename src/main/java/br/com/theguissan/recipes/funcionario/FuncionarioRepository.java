package br.com.theguissan.recipes.funcionario;

import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.JpaEntityRepository;
import br.com.theguissan.recipes.entity.Funcionario;

@Repository
public class FuncionarioRepository extends JpaEntityRepository<Funcionario> {

}
