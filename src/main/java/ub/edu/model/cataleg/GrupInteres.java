package ub.edu.model.cataleg;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class GrupInteres {

    private List<Tematica> tematiques;
    private List<ContingutDigital> contingutDigitals;

    private String nomGrupInteres;
    private String descripcioGrupInteres;

    private String codiAcces;

    public GrupInteres(String nomGrupInteres, String descripcioGrupInteres) {
        this.nomGrupInteres = nomGrupInteres;
        this.descripcioGrupInteres = descripcioGrupInteres;
        tematiques = new ArrayList<Tematica>();
        contingutDigitals = new ArrayList<ContingutDigital>();
        Random random = new Random();
        codiAcces = nomGrupInteres + "2024";
    }

    public String getNom() {
        return nomGrupInteres;
    }
    public void setNomGrup(String nomGrup){
        this.nomGrupInteres = nomGrup;
    }
    public String getDescripcioGrupInteres() {
        return descripcioGrupInteres;
    }

    public List<ContingutDigital> getContingutDigitals() {return contingutDigitals;}
    public void setContingutDigitals(List<ContingutDigital> contingutDigitals) {
        this.contingutDigitals = contingutDigitals;
    }
    public void addTematica(Tematica t) {
        if (tematiques.size() <= 3) {
            tematiques.add(t);
        }
    }

    public void addContingutDigital(ContingutDigital cd) {
        contingutDigitals.add(cd);
    }

    public String getDescripcio() {
        return descripcioGrupInteres;
    }

    public List<String> getSeries() {
        List<Serie> series = new ArrayList<>();
        for (ContingutDigital cd: contingutDigitals) {
            if (cd instanceof Serie) {
                series.add((Serie) cd);
            }
        }
        ArrayList<String> seriesGrup = new ArrayList<>();
        for (Serie serie: series) {
            seriesGrup.add(serie.getNom());
        }
        Collections.sort(seriesGrup);
        return seriesGrup;
    }

    public List<String> getPelicules() {
        List<Pelicula> pelicules = new ArrayList<>();
        for (ContingutDigital cd: contingutDigitals) {
            if (cd instanceof Pelicula) {
                pelicules.add((Pelicula) cd);
            }
        }
        ArrayList<String> peliculesGrup = new ArrayList<>();
        for (Pelicula pelicula: pelicules) {
            peliculesGrup.add(pelicula.getNom());
        }
        Collections.sort(peliculesGrup);
        return peliculesGrup;
    }

    public void setDescripcio(String groupDescriptionCannotBeNull) {
        descripcioGrupInteres = groupDescriptionCannotBeNull;
    }
    public String getCodiAcces() {
        return codiAcces;
    }

}