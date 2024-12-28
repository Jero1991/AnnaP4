package ub.edu.resources.service;

import ub.edu.model.ED.Parell;
import ub.edu.model.ED.Quartet;
import ub.edu.model.ED.Quintet;
import ub.edu.model.ED.Trio;
import ub.edu.model.Persona;
import ub.edu.model.cataleg.*;
import ub.edu.model.quizz.Pregunta;
import ub.edu.model.quizz.Resposta;
import ub.edu.resources.dao.entities.*;
import ub.edu.resources.dao.relationships.*;

import java.util.List;
import java.util.Optional;

public class DataService {

    // Entitats
    private DAOPersona daoPersona;
    private DAOPelicula daoPelicula;
    private DAOSerie daoSerie;
    private DAOTemporada daoTemporada;
    private DAOEpisodi daoEpisodi;
    private DAOTematica daoTematica;
    private DAOGrupInteres daoGrupInteres;

    // Relacions
    private DAORelacioTematicaPelicula daoRelacioTematicaPelicula;
    private DAORelacioTematicaSerie daoRelacioTematicaSerie;

    private DAORelacioGrupInteresSerie daoRelacioGrupInteresSerie;
    private DAORelacioGrupInteresPelicula daoRelacioGrupInteresPelicula;

    private DAORelacioTematicaGrupInteres daoRelacioTematicaGrupInteres;

    // Valoracions
    private DAORelacioPersonaPeliculaValoracioPunts daoRelacioPersonaPeliculaValoracioPunts;
    private DAORelacioPersonaPeliculaValoracioEstrelles daoRelacioPersonaPeliculaValoracioEstrelles;
    private DAORelacioPersonaPeliculaValoracioLikes daoRelacioPersonaPeliculaValoracioLikes;

    private DAORelacioPersonaEpisodiValoracioPunts daoRelacioPersonaEpisodiValoracioPunts;
    private DAORelacioPersonaEpisodiValoracioEstrelles daoRelacioPersonaEpisodiValoracioEstrelles;
    private DAORelacioPersonaEpisodiValoracioLikes daoRelacioPersonaEpisodiValoracioLikes;

    // Watched
    private DAORelacioPersonaWatchedPelicula daoRelacioPersonaWatchedPelicula;
    private DAORelacioPersonaWatchedSerie daoRelacioPersonaWatchedSerie;
    private DAORelacioPersonaWatchedTemporada daoRelacioPersonaWatchedTemporada;
    private DAORelacioPersonaWatchedEpisodi daoRelacioPersonaWatchedEpisodi;

    private DAORelacioFollowerGrupInteres daoRelacioGrupInteresFollower;
    private DAORelacioMembreGrupInteres daoRelacioGrupInteresMembre;

    // Grup Interes - Preguntes
    private DAOPregunta daoPregunta;
    private DAOResposta daoResposta;
    private DAORelacioGrupInteresCategoriaPregunta daoRelacioGrupInteresCategoriaPregunta;

    public DataService(AbstractFactoryData factory) {

        // Entitats
        daoPersona = factory.createDAOPersona();
        daoPelicula = factory.createDAOPelicula();
        daoSerie = factory.createDAOSerie();
        daoTemporada = factory.createDAOTemporada();
        daoEpisodi = factory.createDAOEpisodi();
        daoTematica = factory.createDAOTematica();
        daoGrupInteres = factory.createDAOGrupInteres();

        // Relacions
        daoRelacioTematicaPelicula = factory.createDAORelacioTematicaPelicula();
        daoRelacioTematicaSerie = factory.createDAORelacioTematicaSerie();

        daoRelacioGrupInteresSerie = factory.createDAORelacioGrupInteresSerie();
        daoRelacioGrupInteresPelicula = factory.createDAORelacioGrupInteresPelicula();

        daoRelacioTematicaGrupInteres = factory.createDAORelacioTematicaGrupInteres();

        // Relacions valoracions - Persona - pelicula
        this.daoRelacioPersonaPeliculaValoracioPunts = factory.createDAORelacioPersonaPeliculaValoracioPunts();
        this.daoRelacioPersonaPeliculaValoracioEstrelles = factory.createDAORelacioPersonaPeliculaValoracioEstrelles();
        this.daoRelacioPersonaPeliculaValoracioLikes = factory.createDAORelacioPersonaPeliculaValoracioLikes();

        // Relacions valoracions - Persona - episodi
        this.daoRelacioPersonaEpisodiValoracioPunts = factory.createDAORelacioPersonaEpisodiValoracioPunts();
        this.daoRelacioPersonaEpisodiValoracioEstrelles = factory.createDAORelacioPersonaEpisodiValoracioEstrelles();
        this.daoRelacioPersonaEpisodiValoracioLikes = factory.createDAORelacioPersonaEpisodiValoracioLikes();

        // Watched
        daoRelacioPersonaWatchedPelicula = factory.createDAORelacioPersonaWatchedPelicula();
        daoRelacioPersonaWatchedSerie = factory.createDAORelacioPersonaWatchedSerie();
        daoRelacioPersonaWatchedTemporada = factory.createDAORelacioPersonaWatchedTemporada();
        daoRelacioPersonaWatchedEpisodi = factory.createDAORelacioPersonaWatchedEpisodi();

        daoRelacioGrupInteresMembre = factory.createDAORelacioMembreGrupInteres();
        daoRelacioGrupInteresFollower = factory.createDAORelacioFollowerGrupInteres();

        // Grup Interes - Preguntes
        daoPregunta = factory.createDAOPregunta();
        daoResposta = factory.createDAOResposta();
        daoRelacioGrupInteresCategoriaPregunta = factory.createDAORelacioGrupInteresCategoriaPregunta();
    }

    public List<Pelicula> getAllPelicules() throws Exception {
        List<Pelicula> pelicules = daoPelicula.getAll();


        return pelicules;
    }

    public List<Tematica> getAllTematiques() throws Exception {
        return daoTematica.getAll();
    }

    public List<Persona> getAllPersones() throws Exception {
        return daoPersona.getAll();
    }

    public List<Serie> getAllSeries() throws Exception {
        List<Serie> series = daoSerie.getAll();
        List<Temporada> temporades = daoTemporada.getAll();
        List<Episodi> episodis = daoEpisodi.getAll();
        for (Temporada temporada: temporades) {
            for (Episodi episodi: episodis) {
                if (episodi.getNomSerie().equals(temporada.getNomSerie()) && episodi.getNumTemporada() == (temporada.getNumTemporada())) {
                    temporada.addEpisodi(episodi);
                }
            }
            for (Serie serie: series) {
                if (serie.getNom().equals(temporada.getNomSerie())) {
                    serie.addTemporada(temporada);
                }
            }
        }
        return series;
    }

    public List<Temporada> getAllTemporades() throws Exception {
        List<Temporada> temporades = daoTemporada.getAll();
        List<Episodi> episodis = daoEpisodi.getAll();
        for (Temporada temporada: temporades) {
            for (Episodi episodi: episodis) {
                if (episodi.getNumTemporada() == temporada.getNumTemporada()) {
                    temporada.addEpisodi(episodi);
                }
            }
        }
        return temporades;
    }

    public Optional<Persona> getPersonaByUsername(String usuari) {
        try {
            return daoPersona.getById(new String[]{usuari});
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Pregunta getPregunta(String preguntaString) {
        try {

            List<Pregunta> preguntes = daoPregunta.getAll();
            Pregunta pregunta = null;
            for (Pregunta p: preguntes) {
                if (p.getQuestion().equals(preguntaString)) {
                    pregunta =  p;
                    break;
                }
            }
            if(pregunta == null) return null;

            List<Resposta> respostes = daoResposta.getAll();

            for (Resposta resposta: respostes) {
                if (resposta.getPreguntaId().equals(pregunta.getId())) {
                    pregunta.addResposta(resposta);
                }
            }
            return pregunta;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Parell<String, String>> getAllRelacionsSeriesTematiques() {
        try {
            return daoRelacioTematicaSerie.getAll();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Parell<String, String>> getAllRelacionsTematicaGrupInteres() {
        try {
            return daoRelacioTematicaGrupInteres.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public List<GrupInteres> getAllGrupsInteres() throws Exception {
        return daoGrupInteres.getAll();
    }

    public List<Parell<String, String>> getAllRelacionsPeliculesTematiques() throws Exception {
        return daoRelacioTematicaPelicula.getAll();
    }

    public List<Parell<String, String>> getAllRelacionsGrupInteresSerie() throws Exception {
        return daoRelacioGrupInteresSerie.getAll();
    }

    public List<Trio<String, String, String>> getAllRelacionsPersonaWatchedPelicula() {
        try {
            return daoRelacioPersonaWatchedPelicula.getAll();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Trio<String, String, String>> getAllRelacionsPersonaWatchedSerie() {
        try {
            return daoRelacioPersonaWatchedSerie.getAll();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Quartet<String, String, Integer, String>> getAllRelacionsPersonaWatchedTemporada() {
        try {
            return daoRelacioPersonaWatchedTemporada.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Quintet<String, String, Integer, Integer, String>> getAllRelacionsPersonaWatchedEpisodi() {
        try {
            return daoRelacioPersonaWatchedEpisodi.getAll();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Quintet<String, String, Integer, Integer, Integer>> getAllRelacionsPersonaEpisodiEstrelles() {
        try {
            return daoRelacioPersonaEpisodiValoracioEstrelles.getAll();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Quintet<String, String, Integer, Integer, Float>> getAllRelacionsPersonaEpisodiPunts() {
        try {
            return daoRelacioPersonaEpisodiValoracioPunts.getAll();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Quintet<String, String, Integer, Integer, Boolean>> getAllRelacionsPersonaEpisodiLikes() {
        try {
            return daoRelacioPersonaEpisodiValoracioLikes.getAll();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Trio<String, String, Integer>> getAllRelacionsPersonaPeliculaEstrelles() {
        try {
            return daoRelacioPersonaPeliculaValoracioEstrelles.getAll();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Trio<String, String, Float>> getAllRelacionsPersonaPeliculaPunts() {
        try {
            return daoRelacioPersonaPeliculaValoracioPunts.getAll();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Trio<String, String, Boolean>> getAllRelacionsPersonaPeliculaLikes() {
        try {
            return daoRelacioPersonaPeliculaValoracioLikes.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean addPersona(Persona persona) {
        try {
            daoPersona.add(persona);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean addRelacioPersonaGrupInteresFollowing(Trio<String, String, String> cp) {
        try {
            daoRelacioGrupInteresFollower.add(cp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addRelacioPersonaGrupInteresMember(Quartet<String, String, String, Integer> cp) {
        try {
            daoRelacioGrupInteresMembre.add(cp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Trio<String, String, String>> getAllRelacionsPersonaFollowingGrupInteres() {
        try {
            return daoRelacioGrupInteresFollower.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Quartet<String, String, String, Integer>> getAllRelacionsPersonaMemberGrupInteres() {
        try {
            return daoRelacioGrupInteresMembre.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Trio<String, String, String>> getAllRelacionsGrupInteresCategoriaPregunta() {
        try {
            return daoRelacioGrupInteresCategoriaPregunta.getAll();
        } catch (Exception e) {
            return null;
        }
    }


}
