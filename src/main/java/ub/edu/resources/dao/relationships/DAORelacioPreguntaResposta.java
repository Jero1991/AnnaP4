package ub.edu.resources.dao.relationships;

import ub.edu.model.ED.Parell;
import ub.edu.resources.dao.DAO;

import java.util.List;

public interface DAORelacioPreguntaResposta extends DAO<Parell<String, List<Parell<String, Boolean>>>> {
}
