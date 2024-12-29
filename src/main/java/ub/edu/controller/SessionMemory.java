package ub.edu.controller;

public class SessionMemory {
    String correuPersona;
    String nomGrup;
    String nomObraAutiovisual;
    String nomPelicula;
    String nomSerie;
    Integer numTemporada;
    Integer numEpisodi;
    String nomTematica;

    String titolEpisodi;
    String tipusObra;
    String tipusValoracio;
    String tipusStrategy;
    private String tipusObraTop;

    public SessionMemory() {
    }

    public String getCorreuPersona() {
        return correuPersona;
    }

    public void setCorreuPersona(String correuPersona) {
        this.correuPersona = correuPersona;
    }

    public String getNomGrup() {
        return nomGrup;
    }

    public void setNomGrup(String nomGrup) {
        this.nomGrup = nomGrup;
    }

    public String getNomPelicula() {
        return nomPelicula;
    }

    public void setNomPelicula(String nomPelicula) {
        this.nomPelicula = nomPelicula;
    }

    public String getNomSerie() {
        return nomSerie;
    }

    public void setNomSerie(String nomSerie) {
        this.nomSerie = nomSerie;
    }

    public Integer getNumTemporada() {
        return numTemporada;
    }

    public void setNumTemporada(Integer numTemporada) {
        this.numTemporada = numTemporada;
    }

    public Integer getNumEpisodi() {
        return numEpisodi;
    }

    public void setNumEpisodi(Integer numEpisodi) {
        this.numEpisodi = numEpisodi;
    }

    public String getNomTematica() {
        return nomTematica;
    }

    public void setNomTematica(String nomTematica) {
        this.nomTematica = nomTematica;
    }

    public String getTipusObra() {
        return tipusObra;
    }

    public void setTipusObra(String tipusObra) {
        this.tipusObra = tipusObra;
    }

    public String getTitolEpisodi() {
        return titolEpisodi;
    }

    public void setTitolEpisodi(String titolEpisodi) {
        this.titolEpisodi = titolEpisodi;
    }

    public void setNomObra(String nom) {
        nomObraAutiovisual = nom;
    }
    public String getNomObra() {
        return nomObraAutiovisual;
    }

    public String getTipusStrategy() {
        return tipusStrategy;
    }

    public void setTipusStrategy(String tipusStrategy) {
        this.tipusStrategy = tipusStrategy;
    }

    public String getTipusValoracio() {
        return tipusValoracio;
    }

    public void setTipusValoracio(String tipusValoracio) {
        this.tipusValoracio = tipusValoracio;
    }

    public void setTipusObraTop(String newValue) { this.tipusObraTop = newValue;
    }

    public String getTipusObraTop() { return tipusObraTop;
    }

    public void clearSession() {
        correuPersona = null;
        nomGrup = null;
        nomObraAutiovisual = null;
        nomPelicula = null;
        nomSerie = null;
        numTemporada = null;
        numEpisodi = null;
        nomTematica = null;
        titolEpisodi = null;
        tipusObra = null;
        tipusValoracio = null;
        tipusStrategy = null;
        tipusObraTop = null;
    }

    public void setMembershipStrategy(String tipusStrategy) {
        this.tipusStrategy = tipusStrategy;
    }
}
