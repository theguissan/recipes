package br.com.theguissan.recipes.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class RestauranteCozinheiroId implements Serializable {
    
    @Serial
    private static final long serialVersionUID = -5688316731692701172L;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "cod_rest_restcoz", nullable = false)
    private Restaurante restaurante;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "cod_coz_restcoz", nullable = false)
    private Cozinheiro cozinheiro;
    
    public RestauranteCozinheiroId() {}
    
    public Cozinheiro getCozinheiro() {
        return this.cozinheiro;
    }
    
    public void setCozinheiro(final Cozinheiro cozinheiro) {
        this.cozinheiro = cozinheiro;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final RestauranteCozinheiroId that = (RestauranteCozinheiroId) o;
        return Objects.equals(this.restaurante, that.restaurante) && Objects.equals(this.cozinheiro, that.cozinheiro);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.restaurante, this.cozinheiro);
    }
    
}
