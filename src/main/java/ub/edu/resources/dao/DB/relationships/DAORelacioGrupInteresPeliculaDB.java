package ub.edu.resources.dao.DB.relationships;

import ub.edu.model.ED.Parell;
import ub.edu.model.ED.Quartet;
import ub.edu.resources.dao.DB.relationships.DAORelacioDB;
import ub.edu.resources.dao.relationships.DAORelacioGrupInteresPelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAORelacioGrupInteresPeliculaDB extends DAORelacioDB<Parell<String, String>> implements DAORelacioGrupInteresPelicula {

    private final Connection connection;

    public DAORelacioGrupInteresPeliculaDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Parell<String, String>> getAll() {
        List<Parell<String, String>> relacions = new ArrayList<>();
        String sql = """
            SELECT
                Pelicula.titol,
                GrupInteres.nomGrup,
            FROM
                Pelicula_GrupInteres
                    LEFT JOIN Pelicula ON Pelicula_GrupInteres.pelicula_id = Pelicula.id
                    LEFT JOIN GrupInteres ON Pelicula_GrupInteres.grup_id = GrupInteres.id
        """;
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                relacions.add(
                        new Parell<>(
                                rs.getString("titol"),
                                rs.getString("nomGrup")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return relacions;
    }

    @Override
    public boolean add(Parell<String, String> relacio) {
        int grup_id = 0;
        int pelicula_id = 0;

        // query pelicula_id
        String sql = String.format("""
            SELECT id FROM Pelicula WHERE titol='%s';
        """, relacio.getElement1());
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            if (rs.next()) {
                pelicula_id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        // query grup_id
        sql = String.format("""
            SELECT id FROM GrupInteres WHERE nomGrup='%s';
        """, relacio.getElement2());
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            if (rs.next()) {
                grup_id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        // insert
        sql = String.format(
                "INSERT INTO Pelicula_GrupInteres ('pelicula_id', 'grup_id') VALUES ('%s', '%s');",
                pelicula_id, grup_id
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

/*    public boolean delete(Parell<String, String> relacio){
        String sql = String.format(
                """
                DELETE FROM Pelicula_GrupInteres WHERE Pelicula_GrupInteres.id IN (
                    SELECT Pelicula_GrupInteres.id FROM Pelicula_GrupInteres
                        LEFT JOIN Pelicula ON Pelicula_GrupInteres.pelicula_id = Pelicula.id
                        LEFT JOIN GrupInteres ON Pelicula_GrupInteres.grup_id = GrupInteres.id
                    WHERE Pelicula.titol= '%s' AND GrupInteres.nomGrup = '%s'
                );
                """,
                relacio.getElement1(), relacio.getElement2()
        );
        try (
                PreparedStatement statement = this.connection.prepareStatement(sql);
        ){
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }*/


}
