package ub.edu.model;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.cataleg.WatchedHistory;
import ub.edu.model.cataleg.WhatNext;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String pwd;
    private String nom;
    private String nompropi;
    private String cognoms;
    private String dni;

    private WatchedHistory watchedHistory;
    private WhatNext whatNext;
    private ArrayList<GrupInteres> grupsInteres;
    private ArrayList<GrupInteres> grupsInteresFollowed;
    private ArrayList<GrupInteres> grupsInteresMembership;


    public Persona(String nom, String pwd) {
        this.pwd = pwd;
        this.nom = nom;
        this.watchedHistory = new WatchedHistory();
        this.whatNext = new WhatNext();
    }

    public Persona(String correu, String nom, String cognoms, String dni, String password) {
        this.nom = correu;
        this.nompropi = nom;
        this.cognoms = cognoms;
        this.dni = dni;
        this.pwd = password;
        this.watchedHistory = new WatchedHistory();
        this.whatNext = new WhatNext();
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
}
