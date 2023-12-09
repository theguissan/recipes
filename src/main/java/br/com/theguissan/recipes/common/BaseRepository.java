package br.com.theguissan.recipes.common;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.descriptor.java.LocalDateJavaType;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class BaseRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    protected CriteriaBuilder cb() {
        return this.getEntityManager().getCriteriaBuilder();
    }
    
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    protected void configurarQueryNativaComDTOComCast(final List<String> campos, final Query query, final Class<?> classe) {
        final NativeQuery<?> nativeQuery = query.unwrap(NativeQuery.class);
        nativeQuery.setResultTransformer(Transformers.aliasToBean(classe));
        
        for (final String campo : campos) {
            Field atributo = null;
            Class<?> classeAtual = classe;
            
            do {
                try {
                    atributo = classeAtual.getDeclaredField(campo.trim());
                } catch (final NoSuchFieldException e) {
                }
            } while ((classeAtual = classeAtual.getSuperclass()) != null);
            
            if (atributo == null) {
                continue;
            }
            
            if (atributo.getType() == BigInteger.class) {
                nativeQuery.addScalar(campo, StandardBasicTypes.BIG_INTEGER);
            } else if (atributo.getType() == Integer.class) {
                nativeQuery.addScalar(campo, StandardBasicTypes.INTEGER);
            } else if (atributo.getType() == BigDecimal.class) {
                nativeQuery.addScalar(campo, StandardBasicTypes.BIG_DECIMAL);
            } else if (atributo.getType() == String.class) {
                nativeQuery.addScalar(campo, StandardBasicTypes.STRING);
            } else if (atributo.getType() == Character.class) {
                nativeQuery.addScalar(campo, StandardBasicTypes.CHARACTER);
            } else if (atributo.getType() == Boolean.class) {
                nativeQuery.addScalar(campo, StandardBasicTypes.BOOLEAN);
            } else if (atributo.getType() == Long.class) {
                nativeQuery.addScalar(campo, StandardBasicTypes.LONG);
            } else if (atributo.getType() == LocalDate.class) {
                nativeQuery.addScalar(campo, LocalDateJavaType.INSTANCE.getJavaType());
            } else if (atributo.getType() == LocalDateTime.class) {
                nativeQuery.addScalar(campo, LocalDateTimeJavaType.INSTANCE.getJavaType());
            } else {
                nativeQuery.addScalar(campo);
            }
        }
    }
    
}
