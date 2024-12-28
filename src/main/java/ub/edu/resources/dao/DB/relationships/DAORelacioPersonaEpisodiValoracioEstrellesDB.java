package ub.edu.resources.dao.DB.relationships;

import ub.edu.model.ED.Quintet;
import ub.edu.resources.dao.relationships.DAORelacioPersonaEpisodiValoracioEstrelles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class DAORelacioPersonaEpisodiValoracioEstrellesDB extends DAORelacioDB<Quintet<String, String, Integer, Integer, Integer>> implements DAORelacioPersonaEpisodiValoracioEstrelles {

    private final Connection connection;

    public DAORelacioPersonaEpisodiValoracioEstrellesDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Quintet<String, String, Integer, Integer, Integer>> getAll() {
        List<Quintet<String, String, Integer, Integer, Integer>> relacions = new ArrayList<>();
        String sql = """
            SELECT
                Persona.correuElectronic,
                Serie.titol,
                Temporada.numTemporada,
                Episodi.numEpisodi,
                ValoracioEstrelles.puntuacio
            FROM
                Episodi_ValoracioEstrelles AS Relacio
                    LEFT JOIN Persona ON Relacio.persona_id = Persona.id
                    LEFT JOIN Episodi ON Relacio.episodi_id = Episodi.id
                    LEFT JOIN ValoracioEstrelles ON Relacio.valoracio_id = ValoracioEstrelles.id
                    LEFT JOIN Temporada ON Episodi.temporada_id = Temporada.id
                    LEFT JOIN Serie ON Temporada.serie_id = Serie.id
        """;
        try (
            ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                relacions.add(
                    new Quintet<>(
                        rs.getString("correuElectronic"),
                        rs.getString("titol"),
                        rs.getInt("numTemporada"),
                        rs.getInt("numEpisodi"),
                        rs.getInt("puntuacio")
                    )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return relacions;
    }

    @Override
    public boolean add(Quintet<String, String, Integer, Integer, Integer> relacio) {
        // insert
        String sql = String.format("""
            INSERT INTO Episodi_ValoracioEstrelles (persona_id, episodi_id, valoracio_id)
            VALUES (
               (SELECT id FROM Persona WHERE correuElectronic = "%s"),
               (
                    SELECT Episodi.id
                    FROM Episodi
                        LEFT JOIN Temporada ON Episodi.temporada_id = Temporada.id
                        LEFT JOIN Serie ON Temporada.serie_id = Serie.id
                    WHERE
                        Serie.titol = "%s" AND
                        Temporada.numTemporada = %d AND
                        Episodi.numEpisodi = %d
               ),
                (SELECT id FROM ValoracioEstrelles WHERE puntuacio = %d)
            );
        """,
            relacio.getElement1(),  // persona.correu
            relacio.getElement2(),  // serie.titol
            relacio.getElement3(),  // temporada.num
            relacio.getElement4(),  // episodi.num
            relacio.getElement5()  // valoracio.puntuacio
        );
        try (
            PreparedStatement statement = this.connection.prepareStatement(sql);
        ){
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Quintet<String, String, Integer, Integer, Integer> relacio){
        String sql = String.format("""
            DELETE FROM Episodi_ValoracioEstrelles
            WHERE Episodi_ValoracioEstrelles.ROWID IN (
                SELECT Episodi_ValoracioEstrelles.ROWID
                FROM Episodi_ValoracioEstrelles
                    LEFT JOIN Persona ON Episodi_ValoracioEstrelles.persona_id = Persona.id
                    LEFT JOIN Episodi ON Episodi_ValoracioEstrelles.episodi_id = Episodi.id
                    LEFT JOIN ValoracioEstrelles ON Episodi_ValoracioEstrelles.valoracio_id = ValoracioEstrelles.id
                    LEFT JOIN Temporada ON Episodi.temporada_id = Temporada.id
                    LEFT JOIN Serie ON Temporada.serie_id = Serie.id
                WHERE
                    Persona.correuElectronic = "%s" AND
                    Serie.titol = "%s" AND
                    Temporada.numTemporada = %d AND
                    Episodi.numEpisodi = %d AND
                    ValoracioEstrelles.puntuacio = %d
            );
        """,
            relacio.getElement1(),  // persona.correu
            relacio.getElement2(),  // serie.titol
            relacio.getElement3(),  // temporada.num
            relacio.getElement4(),  // episodi.num
            relacio.getElement5()  // valoracio.puntuacio
        );

        try (
            PreparedStatement statement = this.connection.prepareStatement(sql);
        ){
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
