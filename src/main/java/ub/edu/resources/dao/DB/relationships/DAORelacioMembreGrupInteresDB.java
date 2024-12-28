package ub.edu.resources.dao.DB.relationships;

import ub.edu.model.ED.Parell;
import ub.edu.model.ED.Quartet;
import ub.edu.resources.dao.DB.relationships.DAORelacioDB;
import ub.edu.resources.dao.relationships.DAORelacioMembreGrupInteres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAORelacioMembreGrupInteresDB extends DAORelacioDB<Quartet<String, String, String, Integer>> implements DAORelacioMembreGrupInteres {

    private final Connection connection;

    public DAORelacioMembreGrupInteresDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Quartet<String, String, String, Integer>> getAll() {
        List<Quartet<String, String, String, Integer>> relacions = new ArrayList<>();
        String sql = """
            SELECT
                Persona.correuElectronic,
                GrupInteres.nomGrup,
                Persona_Membre_GrupInteres.data,
                Persona_Membre_GrupInteres.punts
            FROM
                Persona_Membre_GrupInteres
                    LEFT JOIN Persona ON Persona_Membre_GrupInteres.persona_id = Persona.id
                    LEFT JOIN GrupInteres ON Persona_Membre_GrupInteres.grup_id = GrupInteres.id
        """;
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                relacions.add(
                    new Quartet<>(
                        rs.getString("correuElectronic"),
                        rs.getString("nomGrup"),
                        rs.getString("data"),
                        rs.getInt("punts")
                    )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return relacions;
    }

    @Override
    public boolean add(Quartet<String, String, String, Integer> relacio) {
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
                "INSERT INTO Persona_Membre_GrupInteres ('persona_id', 'grup_id') VALUES ('%s', '%s', '%s', '%d');",
                persona_id, grup_id, relacio.getElement3(), relacio.getElement4()
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
