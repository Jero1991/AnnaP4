package ub.edu.resources.dao.MOCK.entities;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.resources.dao.entities.DAOGrupInteres;

import java.util.*;

public class DAOGrupInteresMOCK implements DAOGrupInteres {

    private Map<String, GrupInteres> llistaGrupInteres = new HashMap<>();

    public DAOGrupInteresMOCK(){
        addGrupInteres("Anime", "Un espai per als apassionats de l'anime! Comparteix teories, recomanacions i moments èpics dels teus animes favorits, amb bon humor i una dosi de passió.");
        addGrupInteres("Reality TV", "Aquí parlem de tot el que passa en el món del reality! Des de drames hilarants fins a moments ridículs, comparteix les teves opinions i riu amb nosaltres!");
        addGrupInteres("Superheroes", "Un grup per als que no poden resistir-se a debatre sobre qui és el millor superheroi. Comparteix històries, còmics i teories sobre l'univers dels superherois!");
        addGrupInteres("Children’s TVs", "Un lloc per recordar els nostres dibuixos animats preferits! Compartim riures i records sobre sèries que ens van fer créixer i que encara ens fan somriure.");
    }

    private void addGrupInteres(String nomGrup, String descripcio){
        llistaGrupInteres.put(nomGrup, new GrupInteres(nomGrup, descripcio));
    }

    @Override
    public Optional<GrupInteres> getById(String[] id) throws Exception {
        return Optional.ofNullable(llistaGrupInteres.get(Objects.requireNonNull(id[0], "Group name cannot be null")));
    }

    @Override
    public List<GrupInteres> getAll() throws Exception {
        return new ArrayList<>(llistaGrupInteres.values());
    }

    @Override
    public boolean add(GrupInteres grupInteres) throws Exception {
        if (getById(new String[]{grupInteres.getNom()}).isPresent()) {
            return false;
        }
        llistaGrupInteres.put(grupInteres.getNom(), grupInteres);
        return true;
    }

    @Override
    public boolean update(GrupInteres grupInteres, String[] params) throws Exception {
        grupInteres.setNomGrup(
                Objects.requireNonNull(params[0], "Group name cannot be null"));
        grupInteres.setDescripcio(
                Objects.requireNonNull(params[1], "Group description cannot be null"));
        return llistaGrupInteres.replace(grupInteres.getNom(), grupInteres) != null;
    }

    @Override
    public boolean delete(GrupInteres grupInteres) throws Exception {
        return llistaGrupInteres.remove(grupInteres.getNom()) != null;
    }
}
