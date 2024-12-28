package ub.edu.resources.dao.DB.relationships;

import java.util.ArrayList;
import java.util.List;

import ub.edu.model.ED.Trio;
import ub.edu.resources.dao.relationships.DAORelacioPersonaWatchedSerie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class DAORelacioPersonaWatchedSerieDB extends DAORelacioDB<Trio<String, String, String>> implements DAORelacioPersonaWatchedSerie{

    private final Connection connection;

    public DAORelacioPersonaWatchedSerieDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Trio<String, String, String>> getAll() {
        List<Trio<String, String, String>> relacions = new ArrayList<>();
        String sql = """
            SELECT
                Persona.correuElectronic,
                Serie.titol,
                Watched_Serie.data
            FROM
                Watched_Serie
                    LEFT JOIN Persona ON Watched_Serie.persona_id = Persona.id
                    LEFT JOIN Serie ON Watched_Serie.serie_id = Serie.id
        """;
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                relacions.add(
                    new Trio<>(
                        rs.getString("correuElectronic"),
                        rs.getString("titol"),
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
    public boolean add(Trio<String, String, String> relacio) {
        int serie_id = 0;
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
        }

        // insert
        sql = String.format(
                "INSERT INTO Watched_Serie ('serie_id', 'persona_id', 'data') VALUES ('%s', '%s', '%s');",
                serie_id, persona_id, relacio.getElement3()
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
