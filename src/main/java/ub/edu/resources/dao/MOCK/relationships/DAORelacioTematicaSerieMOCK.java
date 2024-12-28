package ub.edu.resources.dao.MOCK.relationships;

import ub.edu.model.ED.Parell;
import ub.edu.resources.dao.relationships.DAORelacioTematicaSerie;

public class DAORelacioTematicaSerieMOCK extends DAORelacioMOCK<Parell<String, String>> implements DAORelacioTematicaSerie {

    public DAORelacioTematicaSerieMOCK() {
        addTematicaSerie("Sci-Fi", "Stranger Things");
        addTematicaSerie("Action", "Stranger Things");
        addTematicaSerie("Adventure", "Stranger Things");
        addTematicaSerie("Drama", "Stranger Things");
    }

    private boolean addTematicaSerie(String nomTematica, String nomSerie) {
        return relacions.add(new Parell<>(nomTematica, nomSerie));
    }
}
