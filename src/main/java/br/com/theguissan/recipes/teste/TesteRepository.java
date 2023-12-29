package br.com.theguissan.recipes.teste;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.util.CastUtils;
import org.springframework.stereotype.Repository;

import br.com.theguissan.recipes.common.BaseRepository;
import jakarta.persistence.Query;

@Repository
public class TesteRepository extends BaseRepository {
    
    public List<TesteDto> buscarTeste(final TesteForm form) {
        
        final Query query = this.getEntityManager().createNativeQuery(this.montarConsultaParaBuscarTeste(form));
        
        query.setParameter("primeiroIngrediente", form.getPrimeiroIngrediente());
        query.setParameter("segundoIngrediente", form.getSegundoIngrediente());
        
        final List<String> campos = Arrays.asList(
                "primeiroIngrediente",
                "segundoIngrediente",
                "testador",
                "receita",
                "nota");
        
        this.configurarQueryNativaComDTOComCast(campos, query, TesteDto.class);
        
        return CastUtils.cast(query.getResultList());
    }
    
    private String montarConsultaParaBuscarTeste(final TesteForm form) {
        
        final StringBuilder sql = new StringBuilder();
        
        sql.append(" WITH receitasselecionadas AS (                                             ");
        sql.append("         SELECT r.cod_rec,                                                  ");
        sql.append("                r.nome_rec                                                  ");
        sql.append("           FROM receita r                                                   ");
        sql.append("     INNER JOIN ingrediente_receita ir ON ir.cod_rec_ingrec = r.cod_rec     ");
        sql.append("     INNER JOIN ingrediente i ON i.cod_ingred = ir.cod_ing_ingrec           ");
        sql.append("          WHERE i.nome_ingred IN(:primeiroIngrediente, :segundoIngrediente) ");
        sql.append(" )                                                                          ");
        sql.append("                                                                            ");
        sql.append("     SELECT DISTINCT :primeiroIngrediente as primeiroIngrediente,           ");
        sql.append("            :segundoIngrediente as segundoIngrediente,                      ");
        sql.append("            d.nome_fun as testador,                                         ");
        sql.append("            rs.nome_rec as receita,                                         ");
        sql.append("            t.nota_test as nota                                             ");
        sql.append("       FROM teste t                                                         ");
        sql.append(" INNER JOIN receitasselecionadas rs ON rs.cod_rec = t.cod_rec_test          ");
        sql.append(" INNER JOIN degustador d ON d.cpf_fun = t.cpf_deg_test                      ");
        
        return sql.toString();
    }
    
}
