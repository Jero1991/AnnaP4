package ub.edu.model.cataleg;

import java.util.ArrayList;
import java.util.List;


public class ContingutDigital {

    private String titol;
    private String descripcio;

    protected String idioma;
    protected int durada;
    private String estrena;
    private int tempsDeVisualitzacio;

    private float valoracioImdb;

    private List<Tematica> llistaTematiques;
    public ContingutDigital(String titol) {
        this.titol = titol;
        llistaTematiques = new ArrayList<Tematica>();

    }
    public ContingutDigital(String titol, int anyPrimeraEmissio) {
        this.titol = titol;
        this.estrena = Integer.toString(anyPrimeraEmissio);
        llistaTematiques = new ArrayList<Tematica>();
    }

    public ContingutDigital(String titol,int anyPrimeraEmissio,  String descripcio) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.estrena = Integer.toString(anyPrimeraEmissio);
        llistaTematiques = new ArrayList<Tematica>();
    }

    public ContingutDigital(String titol,int anyPrimeraEmissio,  String descripcio, int durada) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.durada = durada;
        this.estrena = Integer.toString(anyPrimeraEmissio);
        llistaTematiques = new ArrayList<Tematica>();
    }

    public ContingutDigital(String titol, String descripcio, String url, int estrena, String idioma, int durada, float valoracio) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.estrena = Integer.toString(estrena);
        this.idioma = idioma;
        this.durada = durada;
        this.valoracioImdb = valoracio;
        llistaTematiques = new ArrayList<Tematica>();
    }



    public String getNom() {
        return titol;
    }

    public void setNom(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public float getValoracioImdb() {
        return valoracioImdb;
    }

    public List<Tematica> getLlistaTematiques() {
        return llistaTematiques;
    }

    public void setLlistaTematiques(List<Tematica> llistaTematiques) {
        this.llistaTematiques = llistaTematiques;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getDurada() {
        return durada;
    }

    public String getAnyEstrena() {
        return estrena;
    }

    public Object getTitol() { return titol;}

    public void addTematica(String nomTematica)  {
        if ((findTematica(nomTematica)) == null) {
            Tematica t = new Tematica(nomTematica);
            llistaTematiques.add(t);
        }
    }

    private Object findTematica(String nomTematica) {
        for (Tematica t : llistaTematiques) {
            if (t.getNomTematica().equals(nomTematica)) return t;
        }
        return null;
    }

    public boolean isFinished() {
        return tempsDeVisualitzacio != durada;
    }

    public int getTempsDeVisualitzacio() {
        return tempsDeVisualitzacio;
    }
}
