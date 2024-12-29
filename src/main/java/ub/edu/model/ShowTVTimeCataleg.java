package ub.edu.model;

import ub.edu.model.cataleg.*;
import ub.edu.model.cataleg.*;
import ub.edu.model.exceptions.NotAvailableGroupException;
import ub.edu.model.exceptions.NotAvailableMovieException;
import ub.edu.model.exceptions.NotAvailableShowException;

import java.util.*;

public class ShowTVTimeCataleg {
    private List<Serie> llistaSeries;
    private List<Pelicula> llistaPelicules;
    private List<Tematica> llistaTematiques;
    private List<GrupInteres> llistaGrupsInteres;


    public ShowTVTimeCataleg(){

        llistaSeries = new ArrayList<Serie>();
        llistaPelicules = new ArrayList<Pelicula>();
        llistaTematiques = new ArrayList<Tematica>();
        llistaGrupsInteres = new ArrayList<GrupInteres>();
    }
    // Creador el ImUB

    public ShowTVTimeCataleg(List<Serie> llistaSeries, List<Pelicula> llistaPelicules, List<Tematica> llistaTematiques, List<GrupInteres> llistaGrupsInteres) {

        this.llistaSeries = llistaSeries;
        this.llistaPelicules = llistaPelicules;
        this.llistaTematiques = llistaTematiques;
        this.llistaGrupsInteres = llistaGrupsInteres;
    }

    public void setLlistaSeries(List<Serie> llistaSeries) {
        this.llistaSeries = llistaSeries;
    }

    public void setLlistaPelicules(List<Pelicula> llistaPelicules) {
        this.llistaPelicules = llistaPelicules;
    }


    public void setLlistaTematiques(List<Tematica> llistaTematiques) {
        this.llistaTematiques = llistaTematiques;
    }


    public void setLlistaGrupsInteres(List<GrupInteres> llistaGrupsInteres) {this.llistaGrupsInteres = llistaGrupsInteres;}

    public ContingutDigital findContingutDigital(String nomContingut){
        List<ContingutDigital> combinedList = new ArrayList<>(llistaPelicules);
        combinedList.addAll(llistaSeries);
        for (Serie s : llistaSeries) {
            for(Temporada t: s.getTemporades())
                combinedList.addAll(t.getEpisodis());
        }

        for (ContingutDigital p : combinedList) {
            if (p.getNom().equals(nomContingut)) {
                return p;
            }
        }
        return null;
    }

    public Tematica findTematica(String nomTematica) {
        for (Tematica t : llistaTematiques) {
            if (t.getNomTematica().equals(nomTematica)) {
                return t;
            }
        }
        return null;
    }
    public Pelicula findPelicula(String nomPeli) {
        for (Pelicula p : llistaPelicules) {
            if (p.getNom().equals(nomPeli)) {
                return p;
            }
        }
        return null;
    }

    public Serie findSerie(String nomSerie) {
        for (Serie s : llistaSeries) {
            if (s.getNom().equals(nomSerie)) {
                return s;
            }
        }
        return null;
    }

    public GrupInteres findGrupInteres(String nomGrup) throws Exception {
        for (GrupInteres s : llistaGrupsInteres) {
            if (s.getNom().equals(nomGrup)) {
                return s;
            }
        }
        throw new NotAvailableGroupException();
    }

    public  Episodi findEpisodi(String nomSerie, int numTemporada, int numEpisodi) {
        for (Serie s : llistaSeries) {
            if (s.getNom().equals(nomSerie)) {
                return s.findEpisodi(numTemporada, numEpisodi);
            }
        }
        return null;
    }

    public  Episodi findEpisodi(String nomEpisodi) {
        for (Serie s : llistaSeries) {
                return s.findEpisodi(nomEpisodi);
        }
        return null;
    }
    public List<Tematica> getAllTematiques() {
        return llistaTematiques;
    }

    public List<Pelicula> getAllPelicules() {
        return llistaPelicules;
    }

    public List<Serie> getAllSeries() {
        return llistaSeries;
    }

    public List<GrupInteres> getAllGrupsInteres() {
        return llistaGrupsInteres;
    }

    public List<ContingutDigital> getAllContingutsDigitals() {
        List<ContingutDigital> contingutDigitals = new ArrayList<ContingutDigital>();
        contingutDigitals.addAll(llistaPelicules);
        contingutDigitals.addAll(llistaSeries);
        return contingutDigitals;
    }

    public boolean esPelicula(String nomContingut) {
        for (Pelicula p : llistaPelicules) {
            if (p.getNom().equals(nomContingut)) {
                return true;
            }
        }
        return false;
    }

    public Temporada findTemporada(String nomSerie, int numTemporada) {
        for (Serie s : llistaSeries) {
            if (s.getNom().equals(nomSerie)) {
                return s.findTemporada(numTemporada);
            }
        }
        return null;
    }

    public List<HashMap<Object, Object>> getLlistaNomsPelicules(List<Pelicula> sortedList) {
        List<HashMap<Object, Object>> pelisDisponibles = new ArrayList<>();
        for (Pelicula p : sortedList) {
            HashMap<Object, Object> atributPelicula = new HashMap<>();
            String nom = p.getNom();
            atributPelicula.put("nom", nom);
            pelisDisponibles.add(atributPelicula);
        }
        return pelisDisponibles;
    }

    public List<HashMap<Object, Object>> getAllPeliculesPerEstrena() {
        List<Pelicula> sortedList = llistaPelicules;
        sortedList.sort(new Comparator<Pelicula>() {
            public int compare(Pelicula a1, Pelicula a2) {
                return (a2.getAnyEstrena().compareTo(a1.getAnyEstrena()));
            }
        });
        return getLlistaNomsPelicules(sortedList);
    }

    public List<HashMap<Object, Object>> getAllPeliculesPerNom() {
        List<Pelicula> sortedList = llistaPelicules;
        sortedList.sort(new Comparator<Pelicula>() {
            public int compare(Pelicula a1, Pelicula a2) {
                return (a1.getNom().compareTo(a2.getNom()));
            }
        });
        return getLlistaNomsPelicules(sortedList);
    }

    public void addPelicula(String nom,  int estrena, int durada) {
        Pelicula p = new Pelicula(nom, estrena, durada);
        llistaPelicules.add(p);
    }

    public void addSerie(String nom,  int estrena) {
        Serie s = new Serie(nom, estrena);
        llistaSeries.add(s);
    }
    public void addSerie(String nomSerie, String descripcio, String url, int anyEstrena,
                            String idioma, int durada) {
        Serie s = new Serie(nomSerie, descripcio, url, anyEstrena, idioma, durada);
        llistaSeries.add(s);
    }

    public void addTemporada (String nomSerie, int numTemporada) throws Exception {
        Serie serie = findSerie(nomSerie);
        if (serie == null) {
            throw new NotAvailableShowException();
        } else {
            serie.addTemporada(numTemporada);
        }
    }

    public Iterable<String> visualitzarTemporadesSerie(String nomSerie) throws Exception {
        Serie serie = findSerie(nomSerie);
        if (serie == null) {
            throw new NotAvailableShowException();
        } else {
            return serie.visualitzarTemporadesSerie();
        }
    }

    public void addEpisodi(String nomSerie, int numTemporada, int numEpisodi, String títolEpisodi, int durada) throws Exception{
        Serie serie = findSerie(nomSerie);
        if (serie == null) {
            throw new NotAvailableShowException();
        } else {
            serie.addEpisodiToTemporada(numTemporada, numEpisodi, títolEpisodi, durada);
        }
    }

    public Iterable<String> visualitzaEpisodisTemporadaSerie(String nomSerie, int numTemporada) throws Exception {
        Serie serie = findSerie(nomSerie);
        if (serie == null) {
            throw new NotAvailableShowException();

        } else {
            return serie.visualitzarEpisodisTemporada(numTemporada);
        }
    }

    public void addTematica(String tematica) {
        Tematica t = new Tematica(tematica);
        llistaTematiques.add(t);
    }

    public void addPelicula(String titol, String descripcio, String url, int estrena, String idioma, int durada, float valoracio) {
        Pelicula p = new Pelicula(titol, descripcio, url, estrena, idioma, durada, valoracio);
        llistaPelicules.add(p);
    }

    public void addTematicaToPelicula(String titol, String tematica) throws Exception {
        Pelicula p = findPelicula(titol);
        if (p!=null) {
            p.addTematica(tematica);
        } else {
            throw new NotAvailableMovieException();
        }
    }

    public List<HashMap<Object, Object>> visualitzarPelisPerTematica(String nomTematica) throws Exception{

        List<Pelicula> sortedList = new ArrayList<>();
        for (Pelicula p : llistaPelicules) {
            List<Tematica> tematiques = p.getLlistaTematiques();

            for (Tematica t : tematiques) {
                if (t.getNomTematica().equals(nomTematica)) {
                    sortedList.add(p);
                }
            }
        }
        sortedList.sort(new Comparator<Pelicula>() {
            public int compare(Pelicula a1, Pelicula a2) {
                return (a1.getNom().compareTo(a2.getNom()));
            }
        });
        return getLlistaNomsPelicules(sortedList);

    }

    public void removeTemporada(String nomSerie, int numTemporada) throws Exception {
        Serie serie = findSerie(nomSerie);
        if (serie != null) {
            serie.removeTemporada(numTemporada);
        } else {
            throw new NotAvailableShowException();
        }
    }

    public void addGrup(String s, String descripcio) {
        GrupInteres g = new GrupInteres(s, descripcio);
        llistaGrupsInteres.add(g);
    }


    public Iterable<String> visualitzarGrupsPerNom() throws Exception {
        ArrayList<String> grupsDisponibles = new ArrayList<>();

        for (GrupInteres grup : getGrupsList()) {
            grupsDisponibles.add(grup.getNom());
        }
        Collections.sort(grupsDisponibles);

        return grupsDisponibles;

    }

    private List<GrupInteres> getGrupsList() throws NotAvailableGroupException {
        if (llistaGrupsInteres.isEmpty()) {
            throw new NotAvailableGroupException();
        }
        return llistaGrupsInteres;
    }

    public void afegirSerie2Grup(String grup, String serie) throws Exception{
        GrupInteres gr = findGrupInteres(grup);
        if (gr == null) {
            throw new NotAvailableGroupException();
        }
        gr.addContingutDigital(findSerie(serie));
    }



    public GrupInteres findGrup(String nomGrup) throws Exception {

        for (GrupInteres g : llistaGrupsInteres ) {
            if (g.getNom().equals(nomGrup)) {
                return g;
            }
        }
        throw new NotAvailableGroupException();
    }

    public List<HashMap<Object, Object>> getAllGrupsInteresPerNom() {
        List<HashMap<Object, Object>> GrupsInteresDisponibles = new ArrayList<>();
        for (GrupInteres c : getAllGrupsInteres()) {
            HashMap<Object, Object> atributGrupInteres = new HashMap<>();
            String nom = c.getNom();
            atributGrupInteres.put("nom", nom);
            GrupsInteresDisponibles.add(atributGrupInteres);
        }
        return GrupsInteresDisponibles;
    }

    public List<HashMap<Object, Object>> getAllSeriesPerNom() {
        List<HashMap<Object, Object>> seriesDisponibles = new ArrayList<>();
        for (Serie s : getAllSeries()) {
            HashMap<Object, Object> atributSerie = new HashMap<>();
            String nom = s.getNom();
            atributSerie.put("nom", nom);
            seriesDisponibles.add(atributSerie);
        }
        return seriesDisponibles;
    }


    public ContingutDigital findContingut(String nomContingut) {
        for (ContingutDigital c : getAllContingutsDigitals()) {
            if (c.getNom().equals(nomContingut)) {
                return c;
            }
        }
        return null;
    }

    public void setMembershipStrategy(String strategy) {
        for (GrupInteres g : llistaGrupsInteres) {
            g.setMembershipStrategy(strategy);
        }
    }
}
