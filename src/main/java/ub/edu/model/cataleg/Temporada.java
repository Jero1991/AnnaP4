package ub.edu.model.cataleg;

import ub.edu.model.exceptions.DuplicateEpisodiException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Temporada {
    private int numTemporada;
    private String nomSerie;
    private List<Episodi> llistaEpisodis;

    public Temporada(String nomSerie, int i) {
        this.nomSerie = nomSerie;
        this.numTemporada = i;
        llistaEpisodis = new ArrayList<Episodi>();
    }

    public String getNomSerie() {
        return nomSerie;
    }

    public void setNomSerie(String nomSerie) {
        this.nomSerie = nomSerie;
    }

    public void addEpisodi(Episodi episodi) {
        llistaEpisodis.add(episodi);
    }

    public int getNumTemporada() {
        return numTemporada;
    }

    public List<Episodi> getEpisodis() {
        return llistaEpisodis;
    }

    public Episodi findEpisodi(int numEpisodi) {
        if (numEpisodi <= llistaEpisodis.size()) {
            boolean trobat = false;
            int i = 0;
            while (!trobat && i < llistaEpisodis.size()) {
                if (llistaEpisodis.get(i).getNumEpisodi() == numEpisodi) {
                    trobat = true;
                } else i++;
            }
            if (trobat) return llistaEpisodis.get(i);
            else return null;
        } else return null;
    }

    public Episodi findEpisodi(String nomEpisodi) {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < llistaEpisodis.size()) {
            if (llistaEpisodis.get(i).getNom().equals(nomEpisodi)) {
                trobat = true;
            } else i++;
        }
        if (trobat) return llistaEpisodis.get(i);
        else return null;
    }

    public void addEpisodi( int numEpisodi, String nom, int durada) throws Exception {
        if (findEpisodi(numEpisodi)!= null) throw new DuplicateEpisodiException();
        else {
            Episodi episodi = new Episodi(nomSerie, numTemporada, numEpisodi, nom, durada);
            llistaEpisodis.add(episodi);
        }
    }

    public Iterable<String> visualitzarEpisodisTemporada() {
        List<String> episodisDisponibles = new ArrayList<>();
        List<Episodi> sortedList = llistaEpisodis;
        sortedList.sort(new Comparator<Episodi>() {
            public int compare(Episodi a1, Episodi a2) {
                return (Integer.compare(a1.getNumEpisodi(), a2.getNumEpisodi()));
            }
        });

        for (Episodi e : sortedList) {
            episodisDisponibles.add(e.getNom());
        }
        return episodisDisponibles;
    }

    public String getNom() {
        return nomSerie + " - Temporada " + numTemporada;
    }
}
