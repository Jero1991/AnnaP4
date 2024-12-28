package ub.edu.resources.dao.MOCK.relationships;

import ub.edu.model.ED.Parell;
import ub.edu.resources.dao.relationships.DAORelacioTematicaGrupInteres;

import java.util.List;

public class DAORelacioTematicaGrupInteresMOCK extends DAORelacioMOCK<Parell<String, String>> implements DAORelacioTematicaGrupInteres {

    public DAORelacioTematicaGrupInteresMOCK(){
        addTematicaGrupInteres("Anime", "Sci-Fi");
        addTematicaGrupInteres("Reality TV", "Comedy");
        addTematicaGrupInteres("Superheroes", "Action");
        addTematicaGrupInteres("Children’s TVs", "Fantasy");

    }

    private void addTematicaGrupInteres(String nomGrup, String nomTematica) {
        relacions.add(new Parell<>(nomTematica, nomGrup));
    }
}

