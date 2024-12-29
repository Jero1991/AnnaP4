package ub.edu.model;

import ub.edu.model.cataleg.ContingutDigital;
import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.cataleg.WatchedHistory;
import ub.edu.model.cataleg.WhatNext;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PerfilPersona {

    //aquesta classe gestiona les dades dinamiques de les persones, com els seus grups d'interes, les seves valoracions, etc.

    private Persona persona;
    private WhatNext whatNext;
    private WatchedHistory watchedHistory;

    private ArrayList<GrupInteres> grupsInteresFollowed;
    private ArrayList<GrupInteres> grupsInteresMembership;

    private MembershipStrategy membershipStrategy;

    private ArrayList<String> codisAcces;

    private int punts;

    //private Valoracio valoracio;
    public PerfilPersona(Persona persona) {
        this.persona = persona;
        this.grupsInteresFollowed = new ArrayList<>();
        this.grupsInteresMembership = new ArrayList<>();
        this.whatNext = new WhatNext();
        this.watchedHistory = new WatchedHistory();
        this.membershipStrategy = null; //we didn't know the membership strategy yet

        this.codisAcces = new ArrayList<>();
        this.punts = 0;
    }

    //esdevenir membre d'un grup d'interes
    public boolean becomeMember(GrupInteres grup) {
        if (membershipStrategy != null) {
            //return membershipStrategy.becomeMember(, grup);
        }
        return false;
    }

    public Persona getPersona() {
        return persona;
    }

    public ArrayList<GrupInteres> getGrupsInteresFollowed() {
        return grupsInteresFollowed;
    }

    public ArrayList<GrupInteres> getGrupsInteresMembership() {return grupsInteresMembership;}

    public WhatNext getWhatNext() {
        return whatNext;
    }

    public WatchedHistory getWatchedHistory() {
        return watchedHistory;
    }

    /*
    public boolean afegirAWatchedHistory(LocalDateTime data, ContingutDigital contingut) {
        if (contingut.getTempsDeVisualitzacio() != 0) {
            watchedHistory.afegirWatchedContent(data, contingut);
            return true;
        }
        return false;
    }*/

    public void addGrupInteresFollowed(GrupInteres grupInteres) {
        grupsInteresFollowed.add(grupInteres);
    }

    public boolean isFollowed(GrupInteres grupInteres) {
        return grupsInteresFollowed.contains(grupInteres);
    }

    public boolean isMember(GrupInteres grupInteres) {
        return grupsInteresMembership.contains(grupInteres);
    }

    public void addGrupInteresMembership(GrupInteres grupInteres) {
        if (isFollowed(grupInteres) && !isMember(grupInteres)) {
            grupsInteresFollowed.remove(grupInteres);
            grupsInteresMembership.add(grupInteres);
        }
    }

    public boolean setMembershipStrategy(String nameStrategy){
        MembershipFactory factory = MembershipFactory.getInstance();
        membershipStrategy = factory.createMembership(nameStrategy);
        return membershipStrategy != null;
    }

    public MembershipStrategy getMembershipStrategy() {
        return membershipStrategy;
    }

    public void addCodiAcces(String codiAcces){
        codisAcces.add(codiAcces);
    }

    public boolean removeCodiAcces(String codiAcces){
        return codisAcces.remove(codiAcces);
    }

    public boolean hasCodiAcces(String codiAcces){
        return codisAcces.contains(codiAcces);
    }

    public void addPunts(int punts){
        this.punts += punts;
    }

    public int getPunts(){
        return punts;
    }

    public void removeGrupInteresFollowed(GrupInteres grup) {
        grupsInteresFollowed.remove(grup);
    }


    public int tirarDau(int i) {
        //tirar un dau que retorna un valor entre 1 i 4
        int valor = (int) (Math.random() * 4) + 1;
        return valor;
    }

}
