package ub.edu.resources.service;


import ub.edu.resources.dao.entities.*;
import ub.edu.resources.dao.relationships.*;


public interface AbstractFactoryData {

    // Entitats
    DAOPersona createDAOPersona();

    DAOEpisodi createDAOEpisodi();

    DAOTemporada createDAOTemporada();

    DAOPelicula createDAOPelicula();

    DAOSerie createDAOSerie();

    DAOTematica createDAOTematica();

    DAOGrupInteres createDAOGrupInteres();

    // Relacions
    DAORelacioTematicaPelicula createDAORelacioTematicaPelicula();

    DAORelacioTematicaSerie createDAORelacioTematicaSerie();

    DAORelacioGrupInteresSerie createDAORelacioGrupInteresSerie();

    DAORelacioGrupInteresPelicula createDAORelacioGrupInteresPelicula();

    DAORelacioTematicaGrupInteres createDAORelacioTematicaGrupInteres();

    // Valoracions
    DAORelacioPersonaPeliculaValoracioPunts createDAORelacioPersonaPeliculaValoracioPunts();

    DAORelacioPersonaPeliculaValoracioEstrelles createDAORelacioPersonaPeliculaValoracioEstrelles();

    DAORelacioPersonaPeliculaValoracioLikes createDAORelacioPersonaPeliculaValoracioLikes();

    DAORelacioPersonaEpisodiValoracioPunts createDAORelacioPersonaEpisodiValoracioPunts();

    DAORelacioPersonaEpisodiValoracioEstrelles createDAORelacioPersonaEpisodiValoracioEstrelles();

    DAORelacioPersonaEpisodiValoracioLikes createDAORelacioPersonaEpisodiValoracioLikes();

    // Watched
    DAORelacioPersonaWatchedPelicula createDAORelacioPersonaWatchedPelicula();

    DAORelacioPersonaWatchedSerie createDAORelacioPersonaWatchedSerie();

    DAORelacioPersonaWatchedTemporada createDAORelacioPersonaWatchedTemporada();

    DAORelacioPersonaWatchedEpisodi createDAORelacioPersonaWatchedEpisodi();

    // Follow+member
    DAORelacioMembreGrupInteres createDAORelacioMembreGrupInteres();

    DAORelacioFollowerGrupInteres createDAORelacioFollowerGrupInteres();

    // GrupInteres - Preguntes
    DAORelacioGrupInteresCategoriaPregunta createDAORelacioGrupInteresCategoriaPregunta();
    DAOPregunta createDAOPregunta();
    DAOResposta createDAOResposta();

    DAORelacioPreguntaResposta createDAORelacioPreguntaResposta();
}
