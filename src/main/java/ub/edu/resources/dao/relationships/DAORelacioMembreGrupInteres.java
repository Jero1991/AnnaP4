package ub.edu.resources.dao.relationships;

import ub.edu.resources.dao.DAO;
import ub.edu.model.ED.Quartet;

public interface DAORelacioMembreGrupInteres extends DAO<Quartet<String, String, String, Integer>> {
    // el tercer string es el dia de començament de la relacio i l'integer pot ser els punts acumulats
}