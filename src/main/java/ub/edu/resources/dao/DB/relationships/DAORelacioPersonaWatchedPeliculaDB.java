package ub.edu.resources.dao.DB.relationships;

import java.util.ArrayList;
import java.util.List;

import ub.edu.model.ED.Trio;
import ub.edu.resources.dao.relationships.DAORelacioPersonaWatchedPelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class DAORelacioPersonaWatchedPeliculaDB extends DAORelacioDB<Trio<String, String, String>> implements DAORelacioPersonaWatchedPelicula{

    private final Connection connection;

    public DAORelacioPersonaWatchedPeliculaDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Trio<String, String, String>> getAll() {
        List<Trio<String, String, String>> relacions = new ArrayList<>();
        String sql = """
            SELECT
                Persona.correuElectronic,
                Pelicula.titol,
                Watched_Pelicula.data
            FROM
                Watched_Pelicula
                    LEFT JOIN Persona ON Watched_Pelicula.persona_id = Persona.id
                    LEFT JOIN Pelicula ON Watched_Pelicula.pelicula_id = Pelicula.id
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
        int pelicula_id = 0;
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

        // query pelicula_id
        sql = String.format("""
            SELECT id FROM Pelicula WHERE titol='%s';
        """, relacio.getElement2());
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            if (rs.next()) {
                pelicula_id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // insert
        sql = String.format(
                "INSERT INTO Watched_Pelicula ('pelicula_id', 'persona_id', 'data') VALUES ('%s', '%s', '%s');",
                pelicula_id, persona_id, relacio.getElement3()
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
