package ub.edu.resources.dao.MOCK.relationships;

import ub.edu.model.ED.Quartet;

import ub.edu.resources.dao.relationships.DAORelacioMembreGrupInteres;


public class DAORelacioMembreGrupInteresMOCK extends DAORelacioMOCK<Quartet<String, String, String, Integer>> implements DAORelacioMembreGrupInteres {

    public DAORelacioMembreGrupInteresMOCK() {

        addMembreGrupInteres("ajaleo@gmail.com", "Anime", "02.02.2023", 125);
    }

    private boolean addMembreGrupInteres(String nomUsuari, String nomGrup, String data, Integer punts) {
        return relacions.add(new Quartet<>(nomUsuari, nomGrup, data, punts));
    }
}
