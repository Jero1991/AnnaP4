package ub.edu.resources.dao.MOCK.relationships;

import ub.edu.model.ED.Parell;
import ub.edu.resources.dao.relationships.DAORelacioGrupInteresSerie;

public class DAORelacioGrupInteresSerieMOCK extends DAORelacioMOCK<Parell<String, String>> implements DAORelacioGrupInteresSerie {

    public DAORelacioGrupInteresSerieMOCK() {
        addGrupInteresSerie("Anime", "Stranger Things");
        addGrupInteresSerie("Anime", "Game of Thrones");
        addGrupInteresSerie("Anime", "The Witcher");
        addGrupInteresSerie("Anime", "Peaky Blinders");
        addGrupInteresSerie("Anime", "Breaking Bad");

        addGrupInteresSerie("Reality TV", "Game of Thrones");
        addGrupInteresSerie("Reality TV", "The Crown");
        addGrupInteresSerie("Reality TV", "The Office");
        addGrupInteresSerie("Reality TV", "Friends");
        addGrupInteresSerie("Reality TV", "The Big Bang Theory");

        addGrupInteresSerie("Superheroes", "The Mandalorian");
        addGrupInteresSerie("Superheroes", "The Witcher");

        addGrupInteresSerie("Children’s TVs", "The Office");
        addGrupInteresSerie("Children’s TVs", "The Mandalorian");
        addGrupInteresSerie("Children’s TVs", "The Office");

    }

    private boolean addGrupInteresSerie(String nomGrup, String nomSerie) {
        return relacions.add(new Parell<>(nomGrup, nomSerie));
    }
}
