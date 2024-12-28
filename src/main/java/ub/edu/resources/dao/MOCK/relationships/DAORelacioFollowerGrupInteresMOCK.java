package ub.edu.resources.dao.MOCK.relationships;

import ub.edu.model.ED.Trio;
import ub.edu.resources.dao.relationships.DAORelacioFollowerGrupInteres;


public class DAORelacioFollowerGrupInteresMOCK extends DAORelacioMOCK<Trio<String, String, String>> implements DAORelacioFollowerGrupInteres {

    public DAORelacioFollowerGrupInteresMOCK() {
        addFollowerGrupInteres("ajaleo@gmail.com", "Anime", "02.02.2023");
        addFollowerGrupInteres("ajaleo@gmail.com", "Superheroes", "02.02.2023");
        addFollowerGrupInteres("nancyarg10@yahoo.com", "Anime", "02.02.2023");
    }

    private boolean addFollowerGrupInteres(String nomUsuari, String nomGrup, String data) {
        return relacions.add(new Trio<>(nomUsuari, nomGrup, data));
    }
}
