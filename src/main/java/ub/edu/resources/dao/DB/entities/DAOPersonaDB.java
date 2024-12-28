package ub.edu.resources.dao.DB.entities;

import ub.edu.model.Persona;
import ub.edu.resources.dao.entities.DAOPersona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DAOPersonaDB implements DAOPersona {

    private final Connection connection;

    public DAOPersonaDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Persona> getAll() {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT correuElectronic, contrasenya FROM Persona";
        try (
                ResultSet rs  = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                personas.add(new Persona(rs.getString("correuElectronic"), rs.getString("contrasenya")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return personas;
    }

    @Override
    public Optional<Persona> getById(String[] id) {
        Persona persona = null;
        String sql = String.format(
                "SELECT correuElectronic, contrasenya FROM Persona WHERE correuElectronic='%s';",
                id[0]
        );
        try (
                ResultSet rs  = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                persona = new Persona(rs.getString("correuElectronic"), rs.getString("contrasenya"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(persona);
    }

    @Override
    public boolean add(final Persona persona) {
        String sql = String.format(
                "INSERT INTO Persona ('correuElectronic', 'contrasenya') VALUES ('%s', '%s');",
                persona.getName(), persona.getPwd()
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
    public boolean update(final Persona persona, String[] params) {
        String name = Objects.requireNonNull(params[0], "Name cannot be null");
        String pwd = Objects.requireNonNull(params[1], "Password cannot be null");

        String sql = String.format(
                "UPDATE Persona SET correuElectronic='%s', contrasenya='%s' WHERE correuElectronic='%s';",
                name, pwd, persona.getName()
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
    public boolean delete(final Persona persona) {
        String sql = String.format(
                "DELETE FROM Persona WHERE correuElectronic='%s';",
                persona.getName()
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
