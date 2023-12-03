package br.com.theguissan.recipes.common;

import java.lang.reflect.ParameterizedType;

import org.springframework.data.util.CastUtils;

public final class GenericUtil {
    
    private static final int PRIMEIRO_ARGUMENTO = 0;
    
    public GenericUtil() {}
    
    public static <E> Class<E> retornarClasseDoDiamante(final Class<?> classe) {
        if (classe != null && classe.getGenericSuperclass() != null) {
            try {
                
                return CastUtils.cast(((ParameterizedType) classe.getGenericSuperclass()).getActualTypeArguments()[PRIMEIRO_ARGUMENTO]);
                
            } catch (final ClassCastException e) {
                throw new ClassCastException("A classe do diamente não pode ser inferida");
            }
        }
        
        throw new ClassCastException("A classe do diamente não pode ser inferida");
    }
    
}
