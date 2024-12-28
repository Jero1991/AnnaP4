package ub.edu.resources.dao.relationships;

import ub.edu.model.ED.Trio;
import ub.edu.resources.dao.DAO;

public interface DAORelacioFollowerGrupInteres extends DAO<Trio<String, String, String>> {
    // el tercer string es el dia de començament de la relacio de Follower amb el Grup d'interes
}