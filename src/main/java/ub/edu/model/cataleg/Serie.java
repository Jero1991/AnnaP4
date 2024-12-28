package ub.edu.model.cataleg;

import ub.edu.model.exceptions.DuplicateTemporadaException;
import ub.edu.model.exceptions.SeasonNotFoundException;
import ub.edu.model.exceptions.ShowWithoutSeasonsException;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Serie extends ContingutDigital {

    private String imatgeUrl;
    private List<Temporada> llistaTemporades;

    public Serie(String nomSerie, String idioma, int anyEstrena) {
        super(nomSerie, anyEstrena);
        llistaTemporades = new ArrayList<Temporada>();
    }


    public Serie(String nomSerie, int anyEstrena) {
        super(nomSerie, anyEstrena);
        llistaTemporades = new ArrayList<Temporada>();
    }

    public Serie(String nomSerie, String descripcio, String url, int anyEstrena, String idioma) {
        super(nomSerie, anyEstrena, descripcio);
        this.imatgeUrl = url;
        llistaTemporades = new ArrayList<Temporada>();
    }

    public Serie(String nomSerie, String descripcio, String url, int anyEstrena, String idioma, int durada) {
        super(nomSerie, anyEstrena, descripcio);
        llistaTemporades = new ArrayList<Temporada>();
        this.imatgeUrl = url;
    }

    public Serie(String nomSerie, String descripcio, String url, int anyEstrena, String idioma, int durada, float valoracioImdb) {
        super(nomSerie, descripcio, url, anyEstrena, idioma, durada, valoracioImdb);
        llistaTemporades = new ArrayList<Temporada>();
        this.imatgeUrl = url;
    }

    public void addTemporada(Temporada temp) {
        llistaTemporades.add(temp);
    }

    public List<Temporada> getTemporades() {
        return llistaTemporades;
    }


    public int getNumTemporades() {
        return llistaTemporades.size();
    }

    public Episodi findEpisodi(int numTemporada, int numEpisodi) {
        if (numTemporada<=llistaTemporades.size()) {
            Temporada temp = findTemporada(numTemporada);
            return temp.findEpisodi(numEpisodi);
        } else return null;
    }

    public Episodi findEpisodi(String nomEpisodi) {
        for (Temporada t : llistaTemporades) {
            Episodi e = t.findEpisodi(nomEpisodi);
            if (e!=null) return e;
        }
        return null;
    }
    public Temporada findTemporada(int numTemporada) {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < llistaTemporades.size()) {
            if (llistaTemporades.get(i).getNumTemporada() == numTemporada) {
                trobat = true;
            } else i++;
        }
        if (trobat) return llistaTemporades.get(i);
        else return null;
    }
    public String getImatgeUrl() {
        return imatgeUrl;
    }

    public Iterable<String> visualitzarTemporadesSerie() throws Exception {
        SortedSet<String> temporadesDisponibles = new TreeSet<>();

        if (llistaTemporades.isEmpty()) {
            throw new ShowWithoutSeasonsException();
        } else {
            for (Temporada t : llistaTemporades) {
                temporadesDisponibles.add(String.valueOf(t.getNumTemporada()));
            }
            return temporadesDisponibles;
        }

    }

    public Iterable<String> visualitzarEpisodisTemporada(int numTemporada) throws Exception {
        Temporada temp = findTemporada(numTemporada);
        if (temp == null) {
            throw new SeasonNotFoundException();
        } else {
            return temp.visualitzarEpisodisTemporada();
        }
    }

    public void addTemporada(int numTemporada) throws Exception {
        if ( findTemporada(numTemporada)!=null) throw new DuplicateTemporadaException();
        else {
            Temporada temporada = new Temporada(getNom(), numTemporada);
            llistaTemporades.add(temporada);
        }
    }
    public void addEpisodiToTemporada(int numTemporada, int numEpisodi, String nomEpisodi, int durada) throws Exception {
        Temporada temp = findTemporada(numTemporada);
        if (temp == null) {
            throw new SeasonNotFoundException();
        } else {
            temp.addEpisodi(numEpisodi, nomEpisodi, durada);
        }
    }

    public void removeTemporada(int numTemporada) throws Exception {
        Temporada temp = findTemporada(numTemporada);
        if (temp == null) {
            throw new SeasonNotFoundException();
        } else {
            llistaTemporades.remove(temp);
        }
    }
}