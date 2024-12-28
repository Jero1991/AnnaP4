package ub.edu.resources.dao.DB.relationships;

import ub.edu.model.ED.Trio;
import ub.edu.resources.dao.relationships.DAORelacioPersonaPeliculaValoracioPunts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class DAORelacioPersonaPeliculaValoracioPuntsDB extends DAORelacioDB<Trio<String, String, Float>> implements DAORelacioPersonaPeliculaValoracioPunts {

    private final Connection connection;

    public DAORelacioPersonaPeliculaValoracioPuntsDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Trio<String, String, Float>> getAll() {
        List<Trio<String, String, Float>> relacions = new ArrayList<>();
        String sql = """
            SELECT
                Persona.correuElectronic,
                Pelicula.titol,
                ValoracioPunts.puntuacio
            FROM
                Pelicula_ValoracioPunts AS Relacio
                    LEFT JOIN Persona ON Relacio.persona_id = Persona.id
                    LEFT JOIN Pelicula ON Relacio.pelicula_id = Pelicula.id
                    LEFT JOIN ValoracioPunts ON Relacio.valoracio_id = ValoracioPunts.id
        """;
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                relacions.add(
                        new Trio<>(
                                rs.getString("correuElectronic"),
                                rs.getString("titol"),
                                rs.getFloat("puntuacio"))
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return relacions;
    }

    @Override
    public boolean add(Trio<String, String, Float> relacio) {
        // insert
        String sql = String.format("""
            INSERT INTO Pelicula_ValoracioPunts (persona_id, pelicula_id, valoracio_id)
            VALUES (
               (SELECT id FROM Persona WHERE correuElectronic = "%s"),
               (SELECT id FROM Pelicula WHERE titol = "%s"),
               (SELECT id FROM ValoracioPunts WHERE puntuacio = %.2f)
            );
        """, relacio.getElement1(), relacio.getElement2(), relacio.getElement3());
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
    public boolean delete(Trio<String, String, Float> relacio){
        String sql = String.format("""
            DELETE FROM Pelicula_ValoracioPunts
            WHERE Pelicula_ValoracioPunts.ROWID IN (
                SELECT Pelicula_ValoracioPunts.ROWID
                FROM Pelicula_ValoracioPunts
                    LEFT JOIN Persona ON Pelicula_ValoracioPunts.persona_id = Persona.id
                    LEFT JOIN Pelicula ON Pelicula_ValoracioPunts.pelicula_id = Pelicula.id
                    LEFT JOIN ValoracioPunts ON Pelicula_ValoracioPunts.valoracio_id = ValoracioPunts.id
                WHERE
                    Persona.correuElectronic = "%s" AND
                    Pelicula.titol = "%s" AND
                    ValoracioPunts.puntuacio = %.2f
            );
        """, relacio.getElement1(), relacio.getElement2(), relacio.getElement3());
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