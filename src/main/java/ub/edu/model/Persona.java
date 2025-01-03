package ub.edu.model;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.cataleg.WatchedHistory;
import ub.edu.model.cataleg.WhatNext;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Persona extends Observable {

    private String pwd;
    private String nom;
    private String nompropi;
    private String cognoms;
    private String dni;
    private int punts;


    private WatchedHistory watchedHistory;
    private WhatNext whatNext;
    private ArrayList<GrupInteres> grupsInteres;
    private ArrayList<GrupInteres> grupsInteresFollowed;
    private ArrayList<GrupInteres> grupsInteresMembership;
    private ArrayList<String> codisAcces;



    public Persona(String nom, String pwd) {
        this.pwd = pwd;
        this.nom = nom;
        this.watchedHistory = new WatchedHistory();
        this.whatNext = new WhatNext();
        this.grupsInteres = new ArrayList<>();
        this.grupsInteresFollowed = new ArrayList<>();
        this.grupsInteresMembership = new ArrayList<>();
        this.codisAcces = new ArrayList<>();
    }

    public Persona(String correu, String nom, String cognoms, String dni, String password) {
        this.nom = correu;
        this.nompropi = nom;
        this.cognoms = cognoms;
        this.dni = dni;
        this.pwd = password;
        this.watchedHistory = new WatchedHistory();
        this.whatNext = new WhatNext();
        this.grupsInteres = new ArrayList<>();
        this.grupsInteresFollowed = new ArrayList<>();
        this.grupsInteresMembership = new ArrayList<>();
        this.codisAcces = new ArrayList<>();
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return nom;
    }

    public void setName(String nom) {
        this.nom = nom;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public WatchedHistory getWatchedHistory() {
        return watchedHistory;
    }

    public WhatNext getWhatNext() {
        return whatNext;
    }

    public ArrayList<GrupInteres> getGrupsInteres() {
        return grupsInteres;
    }

    public List<GrupInteres> getGrupsInteresFollowed() {
        return grupsInteresFollowed;
    }

    public List<GrupInteres> getGrupsInteresMembership() {
        return grupsInteresMembership;
    }

    public void addGrupInteresMembership(GrupInteres grupInteres) {
        if (!grupsInteresMembership.contains(grupInteres)) {
            grupsInteresMembership.add(grupInteres);
        }
    }

    public void addPunts(int punts) {
        this.punts += punts;
    }

    public void addCodiAcces(String codiAcces) {
        codisAcces.add(codiAcces);
    }

    public List<String> getCodisAcces() {
        return codisAcces;
    }

    public boolean removeCodiAcces(String codiAcces){
        return codisAcces.remove(codiAcces);
    }

    public boolean hasCodiAcces(String codiAcces){
        return codisAcces.contains(codiAcces);
    }

    public void removeGrupInteresFollowed(GrupInteres grup) {
        grupsInteresFollowed.remove(grup);
    }

    public void afegirFollower(GrupInteres grup) {
        if (!grupsInteresFollowed.contains(grup)) {
            grupsInteresFollowed.add(grup);
        }
        System.out.println("Afegit a la llista de seguits");
        setChanged();
        notifyObservers("follower");
    }

    public void afegirMembre(GrupInteres grupInteres) {
        if (!grupsInteresMembership.contains(grupInteres)) {
            grupsInteresMembership.add(grupInteres);
        }
        System.out.println("Afegit a la llista de membres");
        setChanged();
        notifyObservers("member");
    }
}
