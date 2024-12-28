package ub.edu.model;

import ub.edu.controller.MessagesCAT;
import ub.edu.model.cataleg.*;
import ub.edu.model.exceptions.*;
import java.util.*;

public class ModelFacade {
    private ShowTVTimeCataleg showTVTimeCataleg;
    private ShowTVTimePersones showTVTimePersones;

    public ModelFacade(ShowTVTimeCataleg showCataleg, ShowTVTimePersones showPersones) {
        this.showTVTimeCataleg = showCataleg;
        this.showTVTimePersones = showPersones;
    }

    // Mètodes de login
    public void loguejarSociStatus(String correu, String password) throws Exception{
        Persona persona = showTVTimePersones.findPersonaCartera(correu);
        if (persona == null) {
            throw new PersonaNotFoundException();
        }
        if (!persona.getPwd().equals(password)) {
            throw new WrongPasswordException();
        }
    }

    // Mètodes de llistes de continguts
    public List<HashMap<Object, Object>> getAllTematiques()  {
        List<Tematica> l = showTVTimeCataleg.getAllTematiques();
        List<HashMap<Object, Object>> tematiquesDisponibles = new ArrayList<>();
        int i;
        i = 0;
        for (Tematica t : l) {
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("id", i++);
            hashMap.put("nom", t.getNomTematica());
            tematiquesDisponibles.add(hashMap);
        }
        return tematiquesDisponibles;
    }

    public List<HashMap<Object, Object>> getAllContingutsDigitalsPerNom() {
        List<HashMap<Object, Object>> contingutsDisponibles = new ArrayList<>();
        Integer id = 0;
        for (ContingutDigital c : showTVTimeCataleg.getAllContingutsDigitals()) {
            HashMap<Object, Object> atributContingut = new HashMap<>();
            atributContingut.put("id", id++);
            String nom = c.getNom();
            atributContingut.put("nom", nom);
            contingutsDisponibles.add(atributContingut);
        }
        return contingutsDisponibles;
    }

    public List<HashMap<Object, Object>> getAllTemporadesDeSerie(String id) {
        List<HashMap<Object, Object>> temporadesDisponibles = new ArrayList<>();
        Serie s = showTVTimeCataleg.findSerie(id);
        for (Temporada t : s.getTemporades()) {
            HashMap<Object, Object> atributTemporada = new HashMap<>();
            atributTemporada.put("numTemporada", t.getNumTemporada());
            temporadesDisponibles.add(atributTemporada);
        }
        return temporadesDisponibles;
    }

    public HashMap<Object, Object> getDetallsSerie(String idContingutAudiovisual) {
        HashMap<Object, Object> atributsSerie = new HashMap<>();
        Serie s = showTVTimeCataleg.findSerie(idContingutAudiovisual);
        atributsSerie.put("imatge", s.getImatgeUrl());
        atributsSerie.put("nom", s.getNom());
        atributsSerie.put("descripcio", s.getDescripcio());
        atributsSerie.put("dataAnyPrimeraEmissio", s.getAnyEstrena());
        atributsSerie.put("idioma", s.getIdioma());
        atributsSerie.put("durada", s.getDurada());

        return atributsSerie;
    }

    public HashMap<Object, Object> getDetallsPelicula(String idContingutAudiovisual) {
        HashMap<Object, Object> atributsPelicula = new HashMap<>();
        Pelicula p = showTVTimeCataleg.findPelicula(idContingutAudiovisual);
        atributsPelicula.put("imatge", p.getURL());
        atributsPelicula.put("nom", p.getNom());
        atributsPelicula.put("descripcio", p.getDescripcio());
        atributsPelicula.put("dataAnyPrimeraEmissio", p.getAnyEstrena());
        atributsPelicula.put("idioma", p.getIdioma());
        atributsPelicula.put("durada", p.getDurada());

        return atributsPelicula;
    }

    public List<HashMap<Object, Object>> getAllEpisodis(String idSerie, int idTemporada) {
        List<HashMap<Object, Object>> episodisDisponibles = new ArrayList<>();
        Serie s = showTVTimeCataleg.findSerie(idSerie);
        Temporada t = s.findTemporada(idTemporada);
        for (Episodi e : t.getEpisodis()) {
            HashMap<Object, Object> atributEpisodi = new HashMap<>();
            atributEpisodi.put("numEpisodi", e.getNumEpisodi());
            episodisDisponibles.add(atributEpisodi);
        }
        return episodisDisponibles;
    }

    public HashMap<Object, Object> getEpisodiDetalls(String idContingutAudiovisual, Integer numTemporada, Integer numEpisodi) {
        HashMap<Object, Object> atributsEpisodi = new HashMap<>();
        Serie s = showTVTimeCataleg.findSerie(idContingutAudiovisual);
        Temporada t = s.findTemporada(numTemporada);
        Episodi e = t.findEpisodi(numEpisodi);
        atributsEpisodi.put("nom", e.getNom());
        atributsEpisodi.put("descripcio", e.getDescripcio());
        atributsEpisodi.put("durada", e.getDurada());
        atributsEpisodi.put("valoracio", e.getValoracioInicial());
        atributsEpisodi.put("imatge", e.getUrl());
        atributsEpisodi.put("numTemporada", e.getNumTemporada());
        atributsEpisodi.put("numEpisodi", e.getNumEpisodi());
        atributsEpisodi.put("nomSerie", e.getNomSerie());
        atributsEpisodi.put("anyEstrena", e.getAnyEstrena());
        atributsEpisodi.put("url", e.getUrl());
        return atributsEpisodi;
    }

    public boolean esPelicula(String nomContingut) {
        return showTVTimeCataleg.esPelicula(nomContingut);
    }

    // Mètodes de WatchedHistory

    public boolean addToWatchedHistoryList(String nomContingut, String correu, String data){
        // TODO: Pràctica 4: Cal afegir el contingut nomContingut a la WatchedHistory del client amb correu correu
        try{
            Persona persona = showTVTimePersones.findPersonaCartera(correu);
            persona.getWatchedHistory().afegirWatchedContent(showTVTimeCataleg.findContingut(nomContingut), data);

            System.out.println("Model Facade: addToWatchedHistoryList -> nomContingut: " + nomContingut + " correu: " + correu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    public boolean addTemporadaToWatchedHistoryList(String nomContingut, int numTemporada, String correu, String data){
        // TODO: Pràctica 4: Cal afegir el contingut nomContingut a la WatchedHistory del client amb correu correu

        try{
            Persona persona = showTVTimePersones.findPersonaCartera(correu);
            persona.getWatchedHistory().afegirWatchedContent(showTVTimeCataleg.findContingut(nomContingut), numTemporada, data);
            System.out.println("Model Facade: addTemporadaToWatchedHistoryList -> nomContingut: " + nomContingut + " correu: " + correu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return true;
    }

    public boolean addEpisodiToWatchedHistoryList(String nomContingut, int numTemporada, int numEpisodi, String correu, String data){
        // TODO: Pràctica 4: Cal afegir el contingut nomContingut a la WatchedHistory del client amb correu correu

        try{
            Persona persona = showTVTimePersones.findPersonaCartera(correu);
            persona.getWatchedHistory().afegirWatchedContent(showTVTimeCataleg.findContingut(nomContingut), numTemporada, numEpisodi, data);
            System.out.println("Model Facade: addEpisodiToWatchedHistoryList -> nomContingut: " + nomContingut + " correu: " + correu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public List<HashMap<Object, Object>> getWatchedHistory(String correu){
        List<HashMap<Object, Object>> watchedHistory = new ArrayList<>();
        // TODO: Pràctica 4: Cal retornar els continguts de la watchedHistory del client amb correu correu
        try{
            Persona persona = showTVTimePersones.findPersonaCartera(correu);
            for (ContingutDigital c : persona.getWatchedHistory().getContingutDigital()) {
                HashMap<Object, Object> atributContingut = new HashMap<>();
                atributContingut.put("nom", c.getNom());
                watchedHistory.add(atributContingut);
            }
            System.out.println("Model Facade: getWatchedHistory -> correu: " + correu );

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return watchedHistory;
    }


    public List<HashMap<Object, Object>> getWatchNext(String correu) {
        List<HashMap<Object, Object>> WatchNext = new ArrayList<>();
        // TODO: Pràctica 4: Cal retornar els continguts de la WatchNext List
        try{
            Persona persona = showTVTimePersones.findPersonaCartera(correu);
            for (ContingutDigital c : persona.getWhatNext().getContingutDigital()) {
                HashMap<Object, Object> atributContingut = new HashMap<>();
                atributContingut.put("nom", c.getNom());
                WatchNext.add(atributContingut);
            }

            System.out.println("Model Facade: getWatchNext -> tipusContingut ");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return WatchNext;
    }

    // Mètodes relatius a grups

    public List<HashMap<Object, Object>> visualitzarGrupsPerNom() throws Exception {
        Iterable<String> list = showTVTimeCataleg.visualitzarGrupsPerNom();
        List<HashMap<Object, Object>> grupsDisponibles = new ArrayList<>();
        int i;
        i = 0;
        for (String g : list) {
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("id", i++);
            hashMap.put("nom", g);
            grupsDisponibles.add(hashMap);
        }
        return grupsDisponibles;
    }

    // TODO Pràctica 4: Cal afegir un mètode per poder obtenir els grups en els què l'usuari no es ni follower ni membre
    public List<HashMap<Object, Object>> getFollowingGrupsPerPersona(String correuPersona)  throws Exception {

        //????? no utilizo el correo
        // TODO Pràctica 4: Cal  obtenir els grups que segueix la persona amb correu "correuPersona"
        // Per a cada grup cal omplir la hashMap que espera la vista

        //List<GrupInteres> grupsDisponibles = new ArrayList<>();
        // TODO: Cal que omplis list amb llista de grups que segueix la persona
        // List<GrupInteres> list;
        //for (GrupInteres g : list) {
          //  HashMap<Object, Object> hashMap = new HashMap<>();
          //  hashMap.put("id", i++);
         //   hashMap.put("nom", g.getNom());
         //   grupsDisponibles.add(hashMap);
        //}

       // return grupsDisponibles;
        Persona persona = showTVTimePersones.findPersonaCartera(correuPersona);
        List<GrupInteres> grupsDisponibles = persona.getGrupsInteres();
        List<GrupInteres> grupsFollowed = persona.getGrupsInteresFollowed();
        for (GrupInteres g : grupsDisponibles){
            HashMap<Object, Object> grupsPersona = new HashMap<>();
            grupsPersona.put("nom del grup: ", g.getNom());
            grupsPersona.put("descripció: ", g.getDescripcioGrupInteres());
        }
        return null;
    }

    public List<HashMap<Object, Object>> getMemberGrupsPerPersona(String correuPersona) {
        // TODO Pràctica 4: Cal  obtenir els grups dels què és membre la persona amb correu "correuPersona"
        // Per a cada grup cal omplir la hashMap que espera la vista

        List<HashMap<Object, Object>> grupsDisponibles = new ArrayList<>();
        // TODO: Cal que omplis list amb llista de grups dels què és membre la persona
        // List<GrupInteres> list;
        //for (GrupInteres g : list) {
        //  HashMap<Object, Object> hashMap = new HashMap<>();
        //  hashMap.put("id", i++);
        //   hashMap.put("nom", g.getNom());
        //   grupsDisponibles.add(hashMap);
        //}

        // return grupsDisponibles;
        return null;
    }

    public void addFollowerGrup(String nomUsuari, String nomGrup) throws Exception {
        //Cal buscar la persona i el grup i despres cridar a afegir follower
        Persona persona = showTVTimePersones.findPersonaCartera(nomUsuari);
        GrupInteres grup = showTVTimeCataleg.findGrupInteres(nomGrup);
        // TODO Pràctica 4: Cal afegir l'usuari "persona" com a follower del grup "grup"

    }

    public void addMemberGrup(String nomUsuari, String nomGrup, int punts) throws Exception {
        //Cal buscar la persona i el grup i despres cridar a afegir member de showTVTimeGrups
        Persona persona = showTVTimePersones.findPersonaCartera(nomUsuari);
        GrupInteres grup = showTVTimeCataleg.findGrupInteres(nomGrup);
        // TODO Pràctica 4: Cal afegir l'usuari "persona" com a membre del grup "grup"
    }

    public HashMap<String, String> sollicitarAcces(String tipusAcces, String correuPersona, String nomGrup) throws Exception{
        Persona persona = showTVTimePersones.findPersonaCartera(correuPersona);
        GrupInteres grup = showTVTimeCataleg.findGrupInteres(nomGrup);
        // TODO Pràctica 4: Cal sol.licitar accés l'usuari "persona" com a membre del grup "grup" segons el tipusAcces
        // TODO Cal retornar a la hash per exemple, amb la clau "tirada" el resultat de la tirada
        // TODO OPT mirar el que cal retornar en el cas de l'accès per Quizz a la classe EscenaTriviaJoc.java
        return null;

    }
    public String comprovarAcces(String tipusAcces, String correuPersona, String nomGrup, String dadaAcces) throws Exception{

        Persona persona = showTVTimePersones.findPersonaCartera(correuPersona);
        GrupInteres grup = showTVTimeCataleg.findGrupInteres(nomGrup);
        // TODO Pràctica 4: comprova accés al grup segons el tipus d'acces
        // TODO Cal retornar al String si es "MEMBRE" o no
        return null;
    }
    // TODO OPT Pràctica 4: Fer els mètodes corresponents a treure un usuari com a Follower
    //  //o treure'l com a membre d'un grup.



    // TODO OPT: Pràctica 4: Mètodes per valorar

    public boolean valorarContingut( String nomContingut, String correu, String valortype, String valoracio) {
        // TODO OPT: Pràctica 4: Cal valorar el contingut nomContingut amb la valoració valoracio de tipus valorType pel client amb correu correu
        System.out.println("Model Facade: valorarContingut -> nomContingut: " + nomContingut + " correu: " + correu + " valortype: " + valortype + " valoracio: " + valoracio);
        return false;
    }

    // Mètodes de filtres per pel·liícules o sèries
    public List<HashMap<Object, Object>> getAllPelicules() {
        List<HashMap<Object, Object>> contingutsDisponibles = new ArrayList<>();
        int id = 0;
        for (Pelicula c : showTVTimeCataleg.getAllPelicules()) {
            HashMap<Object, Object> atributContingut = new HashMap<>();
            atributContingut.put("id", id++);
            String nom = c.getNom();
            atributContingut.put("nom", nom);
            contingutsDisponibles.add(atributContingut);
        }

        return contingutsDisponibles;
    }

    public List<HashMap<Object, Object>> getAllSeries() {
        List<HashMap<Object, Object>> contingutsDisponibles = new ArrayList<>();
        int id = 0;
        for (Serie c : showTVTimeCataleg.getAllSeries()) {
            HashMap<Object, Object> atributContingut = new HashMap<>();
            atributContingut.put("id", id++);
            String nom = c.getNom();
            atributContingut.put("nom", nom);
            contingutsDisponibles.add(atributContingut);
        }

        return contingutsDisponibles;
    }



}
