package ub.edu.resources.dao.DB.relationships;

import java.util.ArrayList;
import java.util.List;

import ub.edu.model.ED.Quintet;
import ub.edu.resources.dao.relationships.DAORelacioPersonaWatchedEpisodi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAORelacioPersonaWatchedEpisodiDB extends DAORelacioDB<Quintet<String, String, Integer, Integer, String>> implements DAORelacioPersonaWatchedEpisodi{

    private final Connection connection;

    public DAORelacioPersonaWatchedEpisodiDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Quintet<String, String, Integer, Integer, String>> getAll() {
        List<Quintet<String, String, Integer, Integer, String>> relacions = new ArrayList<>();
        String sql = """
            SELECT
                Persona.correuElectronic,
                Episodi.temporada_id,
                Episodi.numEpisodi,
                Watched_Episodi.data
            FROM
                Watched_Episodi
                    LEFT JOIN Persona ON Watched_Episodi.persona_id = Persona.id
                    LEFT JOIN Episodi ON Watched_Episodi.episodi_id = Episodi.id
        """;
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            // Find serie titol
            String serie_titol = "";
            Integer num_temporada = 0;
            while (rs.next()) {
                sql = String.format("""
                    SELECT Temporada.numTemporada, Serie.titol
                    FROM Temporada
                        LEFT JOIN Serie ON Temporada.serie_id = Serie.id
                    WHERE Temporada.id = '%d'
                """, rs.getInt("temporada_id"));
                try (
                        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
                ){
                    if (resultSet.next()) {
                        serie_titol = resultSet.getString("titol");
                        num_temporada = resultSet.getInt("numTemporada");
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

                relacions.add(
                        new Quintet<>(
                                rs.getString("correuElectronic"),
                                serie_titol,
                                num_temporada,
                                rs.getInt("numEpisodi"),
                                rs.getString("data")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return relacions;
    }

    @Override
    public boolean add(Quintet<String, String, Integer, Integer, String> relacio) {
        int serie_id = 0;
        int episodi_id = 0;
        int temporada_id = 0;
        int persona_id = 0;

        // query persona_id
        String sql = String.format("""
            SELECT id FROM Persona WHERE correuElectronic='%s';
        """, relacio.getElement1());
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            if (rs.next()) {
                persona_id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        // query serie_id
        sql = String.format("""
            SELECT id FROM Serie WHERE titol='%s';
        """, relacio.getElement2());
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            if (rs.next()) {
                 serie_id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        // query temporada_id
        sql = String.format("""
            SELECT id FROM Temporada
            WHERE serie_id='%d' AND numTemporada='%d';
        """, serie_id, relacio.getElement2());
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            if (rs.next()) {
                temporada_id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        // query episodi
        sql = String.format("""
            SELECT id FROM Episodi
            WHERE temporada_id='%d' AND nom='%s';
        """, temporada_id, relacio.getElement4());
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            if (rs.next()) {
                episodi_id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        // insert
        sql = String.format(
                "INSERT INTO Watched_Episodi ('persona_id', 'episodi_id', 'data') VALUES ('%s', '%s', '%s');",
                persona_id, episodi_id, relacio.getElement5()
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
