package ub.edu.resources;

import ub.edu.model.ED.Parell;
import ub.edu.model.ED.Quartet;
import ub.edu.model.ED.Quintet;
import ub.edu.model.ED.Trio;
import ub.edu.model.*;
import ub.edu.model.cataleg.*;
import ub.edu.model.exceptions.FormatIncorrecteException;
import ub.edu.model.exceptions.NotAvailableGroupException;
import ub.edu.model.exceptions.PersonaExistsException;
import ub.edu.model.exceptions.WrongPasswordException;
import ub.edu.model.quizz.Pregunta;
import ub.edu.resources.service.AbstractFactoryData;
import ub.edu.resources.service.DataService;
import ub.edu.resources.service.FactoryDB;

import java.util.List;

public class ResourcesFacade {

    private AbstractFactoryData factory;      // Origen de les dades
    private DataService dataService;         // Connexio amb les dades
    private ShowTVTimeCataleg showTVTimeCataleg;                  // Model a tractar
    private ShowTVTimePersones showTVTimePersones;

    private ModelFacade modelFacade;

    public ResourcesFacade(ShowTVTimeCataleg showTVTimeCataleg, ShowTVTimePersones showTVTimePersones, ModelFacade modelFacade) {
        // Si cal, pots modificar la crida a aquesta constructora per passar els gestors que necessitis per completar les dades del teu model
        factory = new FactoryDB();
        //factory = new FactoryMOCK();
        dataService = new DataService(factory);
        this.showTVTimeCataleg = showTVTimeCataleg;
        this.showTVTimePersones = showTVTimePersones;
        this.modelFacade = modelFacade;

    }

    public void populateShowTVTimeCataleg() {
        try {
            loadPelicules();
            loadSeries();
            loadTematiques();
            System.out.println("Carregades Series i Pelis i tematiques");
            loadGrupsInteres();
            System.out.println("Carregades Grups d'interes");
            relacionarPeliculesTemes();     // Suposem que les tematiques i les pel·lícules ja estan creades
            System.out.println("Carregades Relacions amb Series i Pelis i Tematiques");
            relacionarSeriesTemes();        // Suposem que les tematiques i les series ja estan creades

            relacionarGrupsInteresTemes();   // Suposem que les tematiques i els grups d'interes ja estan creades
            initPreguntesGrupInteres();      // Suposem els grups ja creats: metode que cal completar
                                            // TODO relacionar preguntes amb grups al model
            System.out.println("Carregat  tot el cataleg: pel·lícules, sèries, temàtiques, grups i preguntes");
        } catch (Exception e) {
            System.out.println("Exception: --> " + e.getMessage());
        }
    }
    public void populateShowTVTimePersones() {
        try {
            initCarteraPersones();
            initPerfilPersones();
            System.out.println("Carregades Persones i Perfil Persones");

        } catch (Exception e) {
            System.out.println("Exception: --> " + e.getMessage());
        }
    }

    public boolean initCarteraPersones() {
        List<Persona> l = null;
        try {
            l = dataService.getAllPersones();
        } catch (Exception e) {
            return false;
        }
        if (l != null) {
            showTVTimePersones.setCarteraPersones(l);
            return true;
        }else return false;
    }

    public boolean loadPelicules() {
        List<Pelicula> l = null;
        try {
            l = dataService.getAllPelicules();
        } catch (Exception e) {
            return false;
        }
        if (l != null) {
            showTVTimeCataleg.setLlistaPelicules(l);
            return true;
        }else return false;
    }

    public boolean loadSeries() {
        List<Serie> l = null;
        try {
            l = dataService.getAllSeries();
        } catch (Exception e) {
            return false;
        }
        if (l != null) {
            showTVTimeCataleg.setLlistaSeries(l);
            return true;
        }else return false;
    }

    public boolean loadTematiques() {
        List<Tematica> l = null;
        try {
            l = dataService.getAllTematiques();
        } catch (Exception e) {
            return false;
        }
        if (l != null) {
            showTVTimeCataleg.setLlistaTematiques(l);
            return true;
        }else return false;
    }
    public boolean loadGrupsInteres() {
        List<GrupInteres> l = null;
        try {
            l = dataService.getAllGrupsInteres();
        } catch (Exception e) {
            return false;
        }
        if (l != null) {
            showTVTimeCataleg.setLlistaGrupsInteres(l);
            return true;
        }else return false;
    }
    private void relacionarPeliculesTemes() {
        try {
            List<Parell<String, String>> relacionsPT = dataService.getAllRelacionsPeliculesTematiques();

            for (Parell p : relacionsPT) {
                Tematica tema = showTVTimeCataleg.findTematica(p.getElement1().toString());
                Pelicula peli = showTVTimeCataleg.findPelicula(p.getElement2().toString());
                peli.addTematica(tema.getNomTematica());
            }
        } catch (Exception e) {
            System.out.println("Exception: --> ERROR en crear relacions Pelicules-Temes");
        }
    }

    private void relacionarSeriesTemes(){
        List<Parell<String, String>> relacionsST = dataService.getAllRelacionsSeriesTematiques();

        for (Parell p : relacionsST) {
            Tematica tema = showTVTimeCataleg.findTematica(p.getElement1().toString());
            Serie serie = showTVTimeCataleg.findSerie(p.getElement2().toString());
            serie.addTematica(tema.getNomTematica());
        }
    }

    private void relacionarGrupsInteresTemes() throws Exception{
        List<Parell<String, String>> relacionsST = dataService.getAllRelacionsTematicaGrupInteres();

        for (Parell p : relacionsST) {
            Tematica tema = showTVTimeCataleg.findTematica(p.getElement1().toString());
            GrupInteres grupInteres = showTVTimeCataleg.findGrupInteres(p.getElement2().toString());
            grupInteres.addTematica(tema);
        }
    }

    private void initPerfilPersones() throws Exception {
        // Es considera que totes les classes amb les quals estan relacionades
        // les watchedHistories i les valoracions, ja estan creades
        // (els Personas i els continguts)
        initWatchedHistory();
        initValoracions();
    }
    private void initWatchedHistory() throws Exception  {
        List<Trio<String, String, String>> relacionsST = dataService.getAllRelacionsPersonaWatchedPelicula();

        for (Trio p : relacionsST) {
            // TODO Practica 4 : afegir la pel.licula a la watchedList
            // nom persona es (p.getElement1().toString(),
            // nom pelicula es p.getElement2().toString(),
            // data es p.getElement3.toString());
        }

        List<Quintet<String, String, Integer, Integer, String>> relacionsST2 = dataService.getAllRelacionsPersonaWatchedEpisodi();
        for (Quintet p : relacionsST2) {
            // TODO Practica 4 : afegir el episodi a la watchedList
            // i actualitzar la WatchNext
            // nom persona es (p.getElement1().toString(),
            // nom serie es p.getElement2().toString(),
            // num temporada es Integer.parseInt(p.getElement3().toString()
            // episodi es p.getElement4.toString()
            // data es p.getElement5.toString());

        }

        List<Trio<String, String, String>> relacionsST3 = dataService.getAllRelacionsPersonaWatchedSerie();
        for (Trio p : relacionsST3) {
            Persona persona = showTVTimePersones.findPersonaCartera(p.getElement1().toString());
            Serie serie = showTVTimeCataleg.findSerie(p.getElement2().toString());
            // TODO  Pràctica 4: Cal afegir la serie a la llista  de WatchedHistory de la persona
            // amb temporades i episodis
            // data es p.getElement3.toString());
        }

        List<Quartet<String, String, Integer, String>> relacionsST4 = dataService.getAllRelacionsPersonaWatchedTemporada();
        for (Quartet p : relacionsST4) {
            // TODO Practica 4 : afegir la Temporada a la watchedList i els episodis
            // i actualitzar la WatchNext
            // nom persona es (p.getElement1().toString(),
            // nom serie es p.getElement2().toString(),
            // num temporada es Integer.parseInt(p.getElement3().toString()
            // data es p.getElement4.toString());
        }

    }

    public void initValoracions() throws Exception {

        iniValoracionsPelicules();
        iniValoracionsEpisodis();
    }

    private void iniValoracionsPelicules() throws Exception {
        List<Trio<String, String, Float>> relacionsST = dataService.getAllRelacionsPersonaPeliculaPunts();

        for (Trio p : relacionsST) {
            // TODO OPT Practica 4 : afegir les valoracions de pel·lícules per punts
            // nom client es (p.getElement1().toString(),
            // nom pelicula es p.getElement2().toString(),
            // valor es p.getElement3.toString());
        }

        List<Trio<String, String, Integer>> relacionsSTI = dataService.getAllRelacionsPersonaPeliculaEstrelles();

        for (Trio p : relacionsSTI) {
            // TODO OPT Practica 4 : afegir les valoracions de pel·lícules per estrelles
            // nom client es (p.getElement1().toString(),
            // nom pelicula es p.getElement2().toString(),
            // estrelles es p.getElement3.toString());
        }
        List<Trio<String, String, Boolean>>  relacionsSTB = dataService.getAllRelacionsPersonaPeliculaLikes();

        for (Trio p : relacionsSTB) {
            // TODO OPT Practica 4 : afegir les valoracions de pel·lícules per likes
            // nom client es (p.getElement1().toString(),
            // nom pelicula es p.getElement2().toString(),
            // likes es p.getElement3.toString());
        }
    }


    private void iniValoracionsEpisodis() throws Exception {
        List<Quintet<String, String, Integer, Integer, Float>> relacionsST = dataService.getAllRelacionsPersonaEpisodiPunts();

        for (Quintet p : relacionsST) {
            // TODO OPT Practica 4 : afegir les valoracions de episodis per punts
            // nom client es (p.getElement1().toString(),
            // nom serie es p.getElement2().toString(),
            // num temporada es p.getElement3.toString(),
            // num episodi es p.getElement4.toString(),
            // punts es p.getElement5.toString());

        }

        List<Quintet<String, String, Integer, Integer, Integer>> relacionsSTI = dataService.getAllRelacionsPersonaEpisodiEstrelles();

        for (Quintet p : relacionsSTI) {
            // TODO OPT Practica 4 : afegir les valoracions de episodis per estrelles
            // nom client es (p.getElement1().toString(),
            // nom serie es p.getElement2().toString(),
            // num temporada es p.getElement3.toString(),
            // num episodi es p.getElement4.toString(),
            // estrelles es p.getElement5.toString());
        }
        List<Quintet<String, String, Integer, Integer, Boolean>> relacionsSTB = dataService.getAllRelacionsPersonaEpisodiLikes();

        for (Quintet p : relacionsSTB) {
            // TODO OPT Practica 4 : afegir les valoracions de episodis per likes
            // nom client es (p.getElement1().toString(),
            // nom serie es p.getElement2().toString(),
            // num temporada es p.getElement3.toString(),
            // num episodi es p.getElement4.toString(),
            // likes es p.getElement5.toString());
        }
    }




    public void populateFollowersMembersGrups() {

        try {
            initFollowerGrupsInteres();
            System.out.println("Carregats els followers dels grups d'interes");
            initMemberGrupsInteres();
            System.out.println("Carregats els members dels grups d'interes");
        } catch (Exception e) {
            System.out.println("Exception: --> ERROR en crear relacions GrupsInteres-Persones");
            System.out.println(e.getMessage());
        }


    }

    private void initFollowerGrupsInteres() throws Exception {
        List<Trio<String, String, String>> relacionsST = dataService.getAllRelacionsPersonaFollowingGrupInteres();

        for (Trio p : relacionsST) {
            // TODO Practica 4: afegir els grups d'interes que segueixen els usuaris
            // nom client es (p.getElement1().toString(),
            // nom grup es p.getElement2().toString(),
            // data es p.getElement3().toString()
        }
    }

    private void initMemberGrupsInteres() throws Exception {
        List<Quartet<String, String, String, Integer>> relacionsST = dataService.getAllRelacionsPersonaMemberGrupInteres();

        for (Quartet p : relacionsST) {
            // TODO Practica 4: afegir els grups d'interes que són membres els usuaris
            // nom client es (p.getElement1().toString(),
            // nom grup es p.getElement2().toString(),
            // data es p.getElement3().toString()
            // punts es p.getElement4().toString()
        }
    }

    public void initPreguntesGrupInteres() throws Exception {
        List<Trio<String, String, String>> relacionsST = dataService.getAllRelacionsGrupInteresCategoriaPregunta();
        // NomGrup, categoria, pregunta
        for (Trio p : relacionsST) {

            Pregunta pregunta = dataService.getPregunta(p.getElement3().toString());

            // TODO OPT Practica 4: afegir els grups d'interes que segueixen els usuaris
            // nom grup es (p.getElement1().toString(),
            // categoria es p.getElement2().toString(),
            // pregunta es p.getElement3().toString()
            // A la variable pregunta ja estenen les respostes
            // TODO: Cal inseris la pregunta a la teva classe del model corresponent que permeti afegir la pregunta al grup

        }
    }

    /**** Aquests mètodes permeten modificar el model i la base de dades des de la interficie ***/
    public void addNewPersona(String correu, String nom, String cognoms, String dni, String password) throws Exception {
        if  (showTVTimePersones.findPersonaCartera(correu) != null)
            throw new PersonaExistsException();
        else if (Seguretat.isMail(correu)) {
            if (Seguretat.isPasswordSegur(password)) {
                Persona persona = new Persona(correu, password);
                if (this.dataService.addPersona(persona)) {
                    showTVTimePersones.addPersona(persona);
                }
            } else throw new WrongPasswordException();
        } else throw new FormatIncorrecteException();
    }


    public void addRelacioFollowingGrupInteres(String correuPersona, String nomGrupInteres, String data) throws Exception {
        Trio<String,String, String> gfp = new Trio<>(correuPersona,nomGrupInteres, data);
        // TODO :  addPersonaFollowerGrupInteres(correuPersona, nomGrupInteres, data);
        if ( !dataService.addRelacioPersonaGrupInteresFollowing(gfp))
            throw new NotAvailableGroupException() ;
    }

    public void addRelacioMemberGrupInteres(String correuPersona, String nomGrupInteres, String data, Integer punts) throws Exception {
        Quartet<String,String, String, Integer> gfp = new Quartet<>(correuPersona,nomGrupInteres, data, punts);
        // TODO: addPersonaMembreGrupInteres(correuPersona, nomGrupInteres, data, punts);
        if ( !dataService.addRelacioPersonaGrupInteresMember(gfp))
            throw new NotAvailableGroupException() ;
    }
}
