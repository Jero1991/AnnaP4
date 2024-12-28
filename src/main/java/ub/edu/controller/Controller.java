package ub.edu.controller;


import ub.edu.model.*;
import ub.edu.resources.ResourcesFacade;


import java.time.LocalDate;
import java.util.*;

public class Controller {
    private ResourcesFacade resourcesFacade;
    private ModelFacade modelFacade;
    private ShowTVTimeCataleg showTVTimeCataleg;
    private ShowTVTimePersones showTVTimePersones;
    private SessionMemory sessionMemory;
    private List<Observer> observers;

    public Controller() {
        this.showTVTimeCataleg = new ShowTVTimeCataleg();
        this.showTVTimePersones = new ShowTVTimePersones();

        this.modelFacade = new ModelFacade(showTVTimeCataleg, showTVTimePersones);
        this.sessionMemory = new SessionMemory();
        resourcesFacade = new ResourcesFacade(showTVTimeCataleg,showTVTimePersones, this.modelFacade);

        resourcesFacade.populateShowTVTimeCataleg();
        resourcesFacade.populateShowTVTimePersones();
        resourcesFacade.populateFollowersMembersGrups(); // TODO: Cal completar aquest mètode
    }

    public SessionMemory getSessionMemory() {
        return sessionMemory;
    }

    public String registrePersona(String user, String pass, String nom, String cognoms, String dni) {
        try {
            resourcesFacade.addNewPersona(user, pass, nom, cognoms, dni);
            return MessagesCAT.SuccessfulFindPersona.getMessage();
        } catch (Exception e) {
            return MessagesCAT.translate(e);
        }
    }

    public String loguejarPersona(String username, String password) {
        try {
            modelFacade.loguejarSociStatus(username, password);
            return MessagesCAT.SuccessfulLogin.getMessage();
        } catch (Exception e) {
            return MessagesCAT.translate(e);
        }
    }

   // Llistes de contiguts digitals i detalls concrets
    public List<HashMap<Object, Object>> visualitzarContingutsDigitalsPerNom() {
        return modelFacade.getAllContingutsDigitalsPerNom();
    }

    public boolean esPelicula(String nom) {
        return modelFacade.esPelicula(nom);
    }

    public List<HashMap<Object, Object>> visualitzarPelisPerNom() {
        return showTVTimeCataleg.getAllPeliculesPerNom();
    }

    public HashMap<Object, Object> getDetallsPelicula(String nomContingutAudiovisual) {
        return modelFacade.getDetallsPelicula(nomContingutAudiovisual);
    }

    public List<HashMap<Object, Object>> visualitzarSeriesPerNom() {
        return showTVTimeCataleg.getAllSeriesPerNom();
    }
    public HashMap<Object, Object> getDetallsSerie(String nomContingutAudiovisual) {
        return modelFacade.getDetallsSerie(nomContingutAudiovisual);
    }
    public List<HashMap<Object, Object>> getAllTemporadesDeSerie(String nomSerie) {
        return modelFacade.getAllTemporadesDeSerie(nomSerie);
    }
    public List<HashMap<Object, Object>> getAllEpisodis(String id, Integer idTemp) {
        return modelFacade.getAllEpisodis(id, idTemp);
    }
    public HashMap<Object, Object> getEpisodiDetalls(String idContingutAudiovisual, Integer numTemporada, Integer numEpisodi) {
        return modelFacade.getEpisodiDetalls(idContingutAudiovisual, numTemporada, numEpisodi);
    }
    public List<HashMap<Object, Object>> getAllTematiques() {
        return modelFacade.getAllTematiques();
    }

    // TODO Pràctica 4: Mètodes de gestió de la Watched History
    public boolean addToWatchedHistory(String nomContingut, String correuPersona) throws Exception {
        //TODO Pràctica 4: cal implementar aquest mètode a modelFacade
        String data = LocalDate.now().toString();
        return modelFacade.addToWatchedHistoryList(nomContingut, correuPersona, data);
    }

    public boolean addTemporadaToWatchedHistory(String nomSerie, int numTemporada, String correuPersona) throws Exception {
        //TODO Pràctica 4: cal implementar aquest mètode a modelFacade
        String data = LocalDate.now().toString();
        return modelFacade.addTemporadaToWatchedHistoryList(nomSerie, numTemporada, correuPersona, data);
    }
    public boolean addEpisodeToWatchedHistory(String nomSerie, int numTemporada, int numEpisodi, String correuPersona) throws Exception {
        //TODO Pràctica 4: cal implementar aquest mètode a modelFacade
        String data = LocalDate.now().toString();
        return modelFacade.addEpisodiToWatchedHistoryList(nomSerie, numTemporada, numEpisodi, correuPersona, data);
    }

    public List<HashMap<Object, Object>> getWatchedHistory(String correuPersona) {
        try {
            //TODO Pràctica 4: cal implementar aquest mètode a modelFacade
            return modelFacade.getWatchedHistory(correuPersona);
        } catch (Exception e) {
            System.out.println(MessagesCAT.translate(e));
            ArrayList<HashMap<Object, Object>> missatge = new ArrayList<>();
            missatge.add(new HashMap<>(Collections.singletonMap("nom", MessagesCAT.translate(e))));
            return missatge;
        }
    }

    public List<HashMap<Object, Object>> getWatchNext( String correuPersona){
        try{
            //TODO Pràctica 4: cal implementar aquest mètode a modelFacade
            return modelFacade.getWatchNext(correuPersona);
        } catch (Exception e) {
            System.out.println(MessagesCAT.translate(e));
            ArrayList<HashMap<Object, Object>> missatge = new ArrayList<>();
            missatge.add(new HashMap<>(Collections.singletonMap("nom", MessagesCAT.translate(e))));
            return missatge;
        }
    }

    // TODO Pràctica 4: Mètodes de gestió de grups
    public List<HashMap<Object, Object>> visualitzarGrupsPerNom() {
        // TODO  Practica 4 : canviar el mètode per a visualitzar tots els grups dels que no s'és follower ni membre
        List<HashMap<Object, Object>> llista = new ArrayList<>();
        try {
            llista = modelFacade.visualitzarGrupsPerNom();
            return llista;
        } catch (Exception e) {
            System.out.println(MessagesCAT.translate(e));
            ArrayList<String> missatge = new ArrayList<>();
            missatge.add(MessagesCAT.translate(e));
            llista.add(new HashMap<>(Collections.singletonMap("nom", missatge)));
            return llista;
        }
    }
    public List<HashMap<Object, Object>> visualitzarFollowingGrupsPerPersona(String correuPersona) {
        // TODO  Practica 4 : obtenir tots els grups dels què la persona és follower.
        try {
            return modelFacade.getFollowingGrupsPerPersona(correuPersona);
        } catch (Exception e) {
            System.out.println(MessagesCAT.translate(e));
            ArrayList<HashMap<Object, Object>> missatge = new ArrayList<>();
            missatge.add(new HashMap<>(Collections.singletonMap("nom", MessagesCAT.translate(e))));
            return missatge;
        }
    }
    public List<HashMap<Object, Object>> visualitzarMemberGrupsPerPersona(String correuPersona) {
        // TODO  Practica 4 : obtenir tots els grups dels què la persona és membre
        try {
            return modelFacade.getMemberGrupsPerPersona(correuPersona);
        } catch (Exception e) {
            System.out.println(MessagesCAT.translate(e));
            ArrayList<HashMap<Object, Object>> missatge = new ArrayList<>();
            missatge.add(new HashMap<>(Collections.singletonMap("nom", MessagesCAT.translate(e))));
            return missatge;
        }
    }

    public String addFollower2Grup(String nomUsuari, String nomGrup) {
        // TODO  Practica 4 : afegir persona com a follower del grup  mitjançant el modelFacade
        try {
            modelFacade.addFollowerGrup(nomUsuari, nomGrup);
            return MessagesCAT.SuccessfulAddFollowerGrup.getMessage();
        } catch (Exception e) {
            return MessagesCAT.translate(e);
        }
    }

    public String addMember2Grup(String nomUsuari, String nomGrup, int punts) {
        // TODO  Practica 4 : afegir persona com a membre del grup mitjançant el modelFacade
        try {
            modelFacade.addMemberGrup(nomUsuari, nomGrup, punts);
            return MessagesCAT.SuccessfulAddMemberGrup.getMessage();
        } catch (Exception e) {
            return (MessagesCAT.translate(e));
        }
    }

    // TODO OPT Pràctica 4: Valorar continguts
    public boolean valorarContingut(String nomContingut, String correu, String valortype, String valoracio) {
        // TODO OPT Practica 4 : afegir les valoracions de pel·lícules
        return modelFacade.valorarContingut(nomContingut, correu, valortype, valoracio);
    }

    // TODO  Pràctica 4: Solicitar accés
    public HashMap<String, String> sollicitarAcces(String tipusAcces, String correuPersona, String nomGrup) {
        try {
            return modelFacade.sollicitarAcces(tipusAcces, correuPersona, nomGrup);
        } catch (Exception e) {
            return (null);
        }
    }

    // TODO OPT Pràctica 4: Validar accés
    public String comprovarAcces(String tipusAcces, String correuPersona, String nomGrup, String dadaAcces) {
        try {
            return modelFacade.comprovarAcces(tipusAcces, correuPersona, nomGrup, dadaAcces);
        } catch (Exception e) {
            return (null);
        }
    }

    public List<HashMap<Object, Object>> getAllPelicules() {
        return modelFacade.getAllPelicules();
    }

    public List<HashMap<Object, Object>> getAllSeries() {
        return modelFacade.getAllSeries();
    }

    public Persona findClientCartera(String correuPersona) {
        return modelFacade.findClientCartera(correuPersona);
    }


/*
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Observable observable, String message) {
        for (Observer o : observers) {
            o.update(observable, message);
        }
    }

    public String addToWatchedHistoryList(String nomContingut, String correuPersona, String data) {
        /*try {
            modelFacade.addToWatchedHistoryList(nomContingut, correuPersona, data);
            return MessagesCAT.SuccessfulAddToWatchedHistory.getMessage();
        } catch (Exception e) {
            return MessagesCAT.translate(e);
        }
        String resultat = "Pel.licula afegida a watchedhistory";
        //revisar
        notifyObservers(new Observable(), resultat);
        return resultat;
    }*/
}
