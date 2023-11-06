package br.com.theguissan.recipes.common;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractRepository<X, Y, Z, S> extends JpaEntityRepository<X> implements SelectionApplierInterface<X>, StandardRepositotyInterface<Y, S, X> {

}
