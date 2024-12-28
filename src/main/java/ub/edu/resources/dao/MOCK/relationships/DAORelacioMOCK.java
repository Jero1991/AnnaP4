package ub.edu.resources.dao.MOCK.relationships;

import ub.edu.resources.dao.DAO;

import java.util.ArrayList;
import java.util.List;

public class DAORelacioMOCK<T> implements DAO<T> {
    protected List<T> relacions = new ArrayList<>();

    @Override
    public List<T> getAll() throws Exception {
        return relacions;
    }

    @Override
    public boolean add(T t) throws Exception {
        if (relacions.contains(t)){
            return false;
        }
        relacions.add(t);
        return true;
    }

    @Override
    public boolean delete(T t) throws Exception {
        if (relacions.contains(t)){
            relacions.remove(t);
            return true;
        }
        return false;
    }
}
