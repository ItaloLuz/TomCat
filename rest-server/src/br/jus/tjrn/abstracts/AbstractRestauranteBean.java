package br.jus.tjrn.abstracts;

import java.util.List;

import br.jus.tjrn.model.Restaurante;

public abstract class AbstractRestauranteBean<T> extends AbstractBean<T> {

    public abstract List<Object[]> getRestaurantes();
    
    public abstract Restaurante findByIdRestaurante(Integer id);

}
