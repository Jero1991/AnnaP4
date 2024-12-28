package ub.edu.resources.dao.DB.relationships;

import java.util.ArrayList;
import java.util.List;

import ub.edu.model.ED.Quartet;
import ub.edu.resources.dao.relationships.DAORelacioPersonaWatchedTemporada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class DAORelacioPersonaWatchedTemporadaDB extends DAORelacioDB<Quartet<String, String, Integer, String>> implements DAORelacioPersonaWatchedTemporada{

    private final Connection connection;

    public DAORelacioPersonaWatchedTemporadaDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Quartet<String, String, Integer, String>> getAll() {
        List<Quartet<String, String, Integer, String>> relacions = new ArrayList<>();
        String sql = """
            SELECT
                Persona.correuElectronic,
                Temporada.serie_id,
                Temporada.numTemporada,
                Watched_Temporada.data
            FROM
                Watched_Temporada
                    LEFT JOIN Persona ON Watched_Temporada.persona_id = Persona.id
                    LEFT JOIN Temporada ON Watched_Temporada.temporada_id = Temporada.id
        """;
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            // Find serie titol
            String serie_titol = "";
            while (rs.next()) {
                sql = String.format("""
                    SELECT titol FROM Serie WHERE id='%d';
                """, rs.getInt("serie_id"));
                try (
                        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
                ){
                    if (resultSet.next()) {
                        serie_titol = resultSet.getString("titol");
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

                relacions.add(
                        new Quartet<>(
                                rs.getString("correuElectronic"),
                                serie_titol,
                                rs.getInt("numTemporada"),
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
    public boolean add(Quartet<String, String, Integer, String> relacio) {
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
        }

        // query temporada_id
        sql = String.format("""
            SELECT id FROM Temporada
                LEFT JOIN Serie ON Temporada.serie_id = Serie.id
            WHERE numTemporada='%d' AND Serie.titol='%s';
        """, relacio.getElement3(), relacio.getElement2());
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            if (rs.next()) {
                temporada_id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // insert
        sql = String.format(
                "INSERT INTO Watched_Temporada ('temporada_id', 'persona_id', 'data') VALUES ('%s', '%s', '%s');",
                temporada_id, persona_id, relacio.getElement4()
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
