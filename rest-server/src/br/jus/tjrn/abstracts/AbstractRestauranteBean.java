package br.jus.tjrn.abstracts;

import java.util.List;

import br.jus.tjrn.model.Restaurante;

public abstract class AbstractRestauranteBean extends AbstractBean {

    public abstract List<Restaurante> getRestaurantes();
    
    public abstract List<Restaurante> getRestaurantesPorBairro();
    
    public abstract List<Restaurante> getRestaurantesPorNome(String nome);
    
    public abstract Restaurante getRestaurantesPorId(Integer id);

}
