package br.jus.tjrn.abstracts;

import java.util.List;

import br.jus.tjrn.model.Restaurante;

public abstract class AbstractRestauranteBean extends AbstractBean {

    public abstract List<Object[]> getRestaurantes();
    
    public abstract Restaurante findByIdRestaurante(Integer id);

}
