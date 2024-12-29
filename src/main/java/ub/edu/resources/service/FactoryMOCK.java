package ub.edu.resources.service;

import ub.edu.resources.dao.MOCK.relationships.*;
import ub.edu.resources.dao.MOCK.entities.*;
import ub.edu.resources.dao.entities.*;
import ub.edu.resources.dao.relationships.*;

public class FactoryMOCK implements AbstractFactoryData {

    // Entitats

    @Override
    public DAOPersona createDAOPersona() {
        return new DAOPersonaMOCK();
    }

    @Override
    public DAOEpisodi createDAOEpisodi() {
        return new DAOEpisodiMOCK();
    }

    @Override
    public DAOTemporada createDAOTemporada() {
        return new DAOTemporadaMOCK();
    }

    @Override
    public DAOPelicula createDAOPelicula() {
        return new DAOPeliculaMOCK();
    }

    @Override
    public DAOSerie createDAOSerie() {
        return new DAOSerieMOCK();
    }

    @Override
    public DAOTematica createDAOTematica() {
        return new DAOTematicaMOCK();
    }

    @Override
    public DAOGrupInteres createDAOGrupInteres() {
        return new DAOGrupInteresMOCK();
    }

    // Relacions

    @Override
    public DAORelacioTematicaPelicula createDAORelacioTematicaPelicula() {
        return new DAORelacioTematicaPeliculaMOCK();
    }

    @Override
    public DAORelacioTematicaSerie createDAORelacioTematicaSerie() {

        return new DAORelacioTematicaSerieMOCK();
    }

    @Override
    public DAORelacioGrupInteresSerie createDAORelacioGrupInteresSerie() {
        return new DAORelacioGrupInteresSerieMOCK();
    }

    @Override
    public DAORelacioGrupInteresPelicula createDAORelacioGrupInteresPelicula() {
        return null;
    }
    @Override
    public DAORelacioTematicaGrupInteres createDAORelacioTematicaGrupInteres() {
        return new DAORelacioTematicaGrupInteresMOCK();
    }


    @Override
    public DAORelacioPersonaPeliculaValoracioPunts createDAORelacioPersonaPeliculaValoracioPunts () {
        return null;
    }

    @Override
    public DAORelacioPersonaPeliculaValoracioEstrelles createDAORelacioPersonaPeliculaValoracioEstrelles () {
        return null;
    }

    @Override
    public DAORelacioPersonaPeliculaValoracioLikes createDAORelacioPersonaPeliculaValoracioLikes () {
        return null;
    }

    @Override
    public DAORelacioPersonaEpisodiValoracioPunts createDAORelacioPersonaEpisodiValoracioPunts () {
        return null;
    }

    @Override
    public DAORelacioPersonaEpisodiValoracioEstrelles createDAORelacioPersonaEpisodiValoracioEstrelles () {
        return null;
    }

    public DAORelacioPersonaEpisodiValoracioLikes createDAORelacioPersonaEpisodiValoracioLikes () {
        return null;
    }


    public DAORelacioPersonaWatchedPelicula createDAORelacioPersonaWatchedPelicula() {
        return null;
    }
    public DAORelacioPersonaWatchedSerie createDAORelacioPersonaWatchedSerie() {
        return null;
    }


    public DAORelacioPersonaWatchedTemporada createDAORelacioPersonaWatchedTemporada() {
        return null;
    }

    public DAORelacioPersonaWatchedEpisodi createDAORelacioPersonaWatchedEpisodi() {
        return null;
    }

    public DAORelacioMembreGrupInteres createDAORelacioMembreGrupInteres() {
        return new DAORelacioMembreGrupInteresMOCK();
    }

    public DAORelacioFollowerGrupInteres createDAORelacioFollowerGrupInteres() {
        return new DAORelacioFollowerGrupInteresMOCK();
    }

    @Override
    public DAORelacioGrupInteresCategoriaPregunta createDAORelacioGrupInteresCategoriaPregunta() {
        return null;
    }

    @Override
    public DAOPregunta createDAOPregunta() {
        return null;
    }

    @Override
    public DAOResposta createDAOResposta() {
        return null;
    }

    @Override
    public DAORelacioPreguntaResposta createDAORelacioPreguntaResposta() {
        return null;
    }

}
