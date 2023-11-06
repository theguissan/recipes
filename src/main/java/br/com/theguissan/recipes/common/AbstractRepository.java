package br.com.theguissan.recipes.common;

public abstract class AbstractRepository<X, Y, Z, S> extends JpaEntityRepository<X> implements SelectionApplierInterface<X>, StandardRepositotyInterface<Y, S, X> {

}
