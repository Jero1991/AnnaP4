package ub.edu.resources.service;

import ub.edu.resources.dao.entities.*;
import ub.edu.resources.dao.relationships.*;

import ub.edu.resources.dao.DB.entities.*;
import ub.edu.resources.dao.DB.relationships.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class FactoryDB implements AbstractFactoryData {

    private static final String DB_FILE_PATH = "./src/main/java/ub/edu/resources/dao/DB/data/showtvtime.sqlite3";

    Connection connection;

    public FactoryDB() {
        this.connection = connect();
    }

    Connection connect() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE_PATH);
            c.setAutoCommit(true);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Connected to db successfully");
        return c;
    }

    void disconnect() {
        try {
            this.connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Closed database successfully");
        return;
    }

    @Override
    public DAOPersona createDAOPersona() {
        return new DAOPersonaDB(this.connection);
    }

    @Override
    public DAOGrupInteres createDAOGrupInteres() {
        return new DAOGrupInteresDB(this.connection);
    }

    @Override
    public DAOEpisodi createDAOEpisodi() {
        return new DAOEpisodiDB(this.connection);
    }

    @Override
    public DAOPelicula createDAOPelicula() {
        return new DAOPeliculaDB(this.connection);
    }

    @Override
    public DAOSerie createDAOSerie() {
        return new DAOSerieDB(this.connection);
    }

    @Override
    public DAOTematica createDAOTematica() {
        return new DAOTematicaDB(this.connection);
    }

    @Override
    public DAOTemporada createDAOTemporada() {
        return new DAOTemporadaDB(this.connection);
    }



    // Relationships

    @Override
    public DAORelacioTematicaGrupInteres createDAORelacioTematicaGrupInteres() {
        return new DAORelacioTematicaGrupInteresDB(this.connection);
    }

    @Override
    public DAORelacioTematicaPelicula createDAORelacioTematicaPelicula() {
        return new DAORelacioTematicaPeliculaDB(this.connection);
    }

    @Override
    public DAORelacioTematicaSerie createDAORelacioTematicaSerie() {
        return new DAORelacioTematicaSerieDB(this.connection);
    }

    @Override
    public DAORelacioFollowerGrupInteres createDAORelacioFollowerGrupInteres() {
        return new DAORelacioFollowerGrupInteresDB(this.connection);
    }

    @Override
    public DAORelacioMembreGrupInteres createDAORelacioMembreGrupInteres() {
        return new DAORelacioMembreGrupInteresDB(this.connection);
    }

    @Override
    public DAORelacioPersonaWatchedPelicula createDAORelacioPersonaWatchedPelicula() {
        return new DAORelacioPersonaWatchedPeliculaDB(this.connection);
    }

    @Override
    public DAORelacioPersonaWatchedSerie createDAORelacioPersonaWatchedSerie() {
        return new DAORelacioPersonaWatchedSerieDB(this.connection);
    }

    @Override
    public DAORelacioPersonaWatchedTemporada createDAORelacioPersonaWatchedTemporada() {
        return new DAORelacioPersonaWatchedTemporadaDB(this.connection);
    }

    @Override
    public DAORelacioPersonaWatchedEpisodi createDAORelacioPersonaWatchedEpisodi() {
        return new DAORelacioPersonaWatchedEpisodiDB(this.connection);
    }

    @Override
    public DAORelacioGrupInteresPelicula createDAORelacioGrupInteresPelicula() {
        return new DAORelacioGrupInteresPeliculaDB(this.connection);
    }

    @Override
    public DAORelacioGrupInteresSerie createDAORelacioGrupInteresSerie() {
        return new DAORelacioGrupInteresSerieDB(this.connection);
    }

    // Valoracions
    @Override
    public DAORelacioPersonaPeliculaValoracioPunts createDAORelacioPersonaPeliculaValoracioPunts() {
        return new DAORelacioPersonaPeliculaValoracioPuntsDB(this.connection);
    }

    @Override
    public DAORelacioPersonaPeliculaValoracioEstrelles createDAORelacioPersonaPeliculaValoracioEstrelles() {
        return new DAORelacioPersonaPeliculaValoracioEstrellesDB(this.connection);
    }

    @Override
    public DAORelacioPersonaPeliculaValoracioLikes createDAORelacioPersonaPeliculaValoracioLikes() {
        return new DAORelacioPersonaPeliculaValoracioLikesDB(this.connection);
    }

    @Override
    public DAORelacioPersonaEpisodiValoracioPunts createDAORelacioPersonaEpisodiValoracioPunts() {
        return new DAORelacioPersonaEpisodiValoracioPuntsDB(this.connection);
    }

    @Override
    public DAORelacioPersonaEpisodiValoracioEstrelles createDAORelacioPersonaEpisodiValoracioEstrelles() {
        return new DAORelacioPersonaEpisodiValoracioEstrellesDB(this.connection);
    }

    @Override
    public DAORelacioPersonaEpisodiValoracioLikes createDAORelacioPersonaEpisodiValoracioLikes() {
        return new DAORelacioPersonaEpisodiValoracioLikesDB(this.connection);
    }

    @Override
    public DAORelacioGrupInteresCategoriaPregunta createDAORelacioGrupInteresCategoriaPregunta() {
        return new DAORelacioGrupInteresCategoriaPreguntaDB(this.connection);
    }

    @Override
    public DAOPregunta createDAOPregunta() {
        return new DAOPreguntaDB(this.connection);
    }

    @Override
    public DAOResposta createDAOResposta() {
        return new DAORespostaDB(this.connection);
    }

    @Override
    public DAORelacioPreguntaResposta createDAORelacioPreguntaResposta() {
        return new DAORelacioPreguntaRespostaDB(this.connection);
    }

}
