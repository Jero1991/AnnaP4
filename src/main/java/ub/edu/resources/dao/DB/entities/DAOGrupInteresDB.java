package ub.edu.resources.dao.DB.entities;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.resources.dao.entities.DAOGrupInteres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DAOGrupInteresDB implements DAOGrupInteres {

    private final Connection connection;

    public DAOGrupInteresDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<GrupInteres> getAll() {
        List<GrupInteres> grups = new ArrayList<>();
        String sql = "SELECT nomGrup, descripcio FROM GrupInteres";
        try (
                ResultSet rs  = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                grups.add(new GrupInteres(rs.getString("nomGrup"), rs.getString("descripcio")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return grups;
    }

    @Override
    public Optional<GrupInteres> getById(String[] id) {
        GrupInteres grup = null;
        String sql = String.format(
                "SELECT nomGrup, descripcio FROM GrupInteres WHERE nomGrup='%s';",
                id[0]
        );
        try (
                ResultSet rs  = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                grup = new GrupInteres(rs.getString("nomGrup"), rs.getString("descripcio"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(grup);
    }

    @Override
    public boolean add(final GrupInteres grup) {
        String sql = String.format(
                "INSERT INTO GrupInteres ('nomGrup', 'descripcio') VALUES ('%s', '%s');",
                grup.getNom(), grup.getDescripcio()
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
    public boolean update(final GrupInteres grup, String[] params) {
        String name = Objects.requireNonNull(params[0], "Name cannot be null");
        String pwd = Objects.requireNonNull(params[1], "Descripcio cannot be null");

        String sql = String.format(
                "UPDATE GrupInteres SET nomGrup='%s', descripcio='%s' WHERE nomGrup='%s';",
                name, pwd, grup.getNom()
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
    public boolean delete(final GrupInteres grup) {
        String sql = String.format(
                "DELETE FROM GrupInteres WHERE nomGrup='%s';",
                grup.getNom()
        );
        try (
                PreparedStatement statement = this.connection.prepareStatement(sql);
        ){
            System.out.println(statement.executeUpdate());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
