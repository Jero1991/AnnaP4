package ub.edu.resources.dao.DB.relationships;

import ub.edu.model.ED.Parell;
import ub.edu.model.ED.Quartet;
import ub.edu.resources.dao.DB.relationships.DAORelacioDB;
import ub.edu.resources.dao.relationships.DAORelacioTematicaGrupInteres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAORelacioTematicaGrupInteresDB extends DAORelacioDB<Parell<String, String>> implements DAORelacioTematicaGrupInteres {

    private final Connection connection;

    public DAORelacioTematicaGrupInteresDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Parell<String, String>> getAll() {
        List<Parell<String, String>> relacions = new ArrayList<>();
        String sql = """
            SELECT
                Tematica.nomTematica,
                GrupInteres.nomGrup
            FROM
                GrupInteres_Tematica
                    LEFT JOIN Tematica ON GrupInteres_Tematica.tematica_id = Tematica.id
                    LEFT JOIN GrupInteres ON GrupInteres_Tematica.grup_id = GrupInteres.id
        """;
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                relacions.add(
                        new Parell<>(
                                rs.getString("nomTematica"),
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
        int tematica_id = 0;

        // query tematica_id
        String sql = String.format("""
            SELECT id FROM Tematica WHERE nomTematica='%s';
        """, relacio.getElement1());
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            if (rs.next()) {
                tematica_id = rs.getInt("id");
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
                "INSERT INTO GrupInteres_Tematica ('tematica_id', 'grup_id') VALUES ('%s', '%s');",
                tematica_id, grup_id
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
