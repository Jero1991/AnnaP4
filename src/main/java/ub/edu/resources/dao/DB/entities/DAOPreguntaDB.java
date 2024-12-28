package ub.edu.resources.dao.DB.entities;

import ub.edu.model.quizz.Pregunta;
import ub.edu.resources.dao.entities.DAOPregunta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DAOPreguntaDB implements DAOPregunta {

    private final Connection connection;

    public DAOPreguntaDB(Connection c){
        this.connection = c;
    }

    @Override
    public List<Pregunta> getAll() throws Exception {
        List<Pregunta> preguntas = new ArrayList<>();
        String sql = "SELECT * FROM Pregunta";
        try (
                ResultSet rs  = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                preguntas.add(new Pregunta(
                        rs.getInt("id"),
                        rs.getString("pregunta")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return preguntas;
    }

    @Override
    public Optional<Pregunta> getById(String[] id) throws Exception {
        Pregunta pregunta = null;
        String sql = String.format(
                "SELECT * FROM Pregunta WHERE pregunta='%s';",
                id[0]
        );
        try (
                ResultSet rs  = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                pregunta = new Pregunta(
                        rs.getInt("id"),
                        rs.getString("pregunta")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(pregunta);
    }

    @Override
    public boolean add(Pregunta pregunta) throws Exception {
        return false;
    }

    @Override
    public boolean update(Pregunta pregunta, String[] params) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Pregunta pregunta) throws Exception {
        return false;
    }

}
