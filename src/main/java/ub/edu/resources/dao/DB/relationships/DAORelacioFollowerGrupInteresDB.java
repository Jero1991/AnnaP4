package ub.edu.resources.dao.DB.relationships;

import ub.edu.model.ED.Parell;
import ub.edu.model.ED.Trio;
import ub.edu.resources.dao.DB.relationships.DAORelacioDB;
import ub.edu.resources.dao.relationships.DAORelacioFollowerGrupInteres;
import ub.edu.resources.dao.relationships.DAORelacioMembreGrupInteres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAORelacioFollowerGrupInteresDB extends DAORelacioDB<Trio<String, String, String>> implements DAORelacioFollowerGrupInteres {

    private final Connection connection;

    public DAORelacioFollowerGrupInteresDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Trio<String, String, String>> getAll() {
        List<Trio<String, String, String>> relacions = new ArrayList<>();
        String sql = """
            SELECT
                Persona.correuElectronic,
                GrupInteres.nomGrup,
                Persona_Follower_GrupInteres.data
            FROM
                Persona_Follower_GrupInteres
                    LEFT JOIN Persona ON Persona_Follower_GrupInteres.persona_id = Persona.id
                    LEFT JOIN GrupInteres ON Persona_Follower_GrupInteres.grup_id = GrupInteres.id
        """;
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                relacions.add(
                        new Trio<>(
                                rs.getString("correuElectronic"),
                                rs.getString("nomGrup"),
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
        int grup_id = 0;
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
                "INSERT INTO Persona_Follower_GrupInteres ('persona_id', 'grup_id', 'data') VALUES ('%s', '%s', '%s');",
                persona_id, grup_id, relacio.getElement3()
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
                DELETE FROM Persona_Follower_GrupInteres WHERE Persona_Follower_GrupInteres.id IN (
                    SELECT Persona_Follower_GrupInteres.id FROM Persona_Follower_GrupInteres
                        LEFT JOIN Persona ON Persona_Follower_GrupInteres.persona_id = Persona.id
                        LEFT JOIN GrupInteres ON Persona_Follower_GrupInteres.grup_id = GrupInteres.id
                    WHERE Persona.correuElectronic= '%s' AND GrupInteres.nomGrup = '%s'
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
