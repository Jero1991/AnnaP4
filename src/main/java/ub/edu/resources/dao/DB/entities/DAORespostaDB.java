package ub.edu.resources.dao.DB.entities;

import ub.edu.model.quizz.Pregunta;
import ub.edu.model.quizz.Resposta;
import ub.edu.resources.dao.entities.DAOResposta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DAORespostaDB implements DAOResposta {

    private final Connection connection;

    public DAORespostaDB(Connection c){
        this.connection = c;
    }

    @Override
    public List<Resposta> getAll() throws Exception {
        List<Resposta> respostas = new ArrayList<>();
        String sql = "SELECT * FROM Resposta";
        try (
                ResultSet rs  = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                respostas.add(new Resposta(
                        rs.getString("resposta"),
                        rs.getBoolean("esCorrecta"),
                        rs.getInt("pregunta_id")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return respostas;
    }

    @Override
    public Optional<Resposta> getById(String[] id) throws Exception {
        Resposta resposta = null;
        String sql = String.format("""
            SELECT
                Resposta.resposta, Resposta.esCorrecta, Resposta.pregunta_id
            FROM
                Resposta
                    LEFT JOIN Pregunta ON Resposta.pregunta_id = Pregunta.id
            WHERE
                Pregunta.pregunta = '%s' AND Resposta.resposta = '%s';
            """, id[0], id[1]
        );
        try (
                ResultSet rs  = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                resposta = new Resposta(
                        rs.getString("resposta"),
                        rs.getBoolean("esCorrecta"),
                        rs.getInt("pregunta_id")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(resposta);
    }

    @Override
    public boolean add(Resposta resposta) throws Exception {
        return false;
    }

    @Override
    public boolean update(Resposta resposta, String[] params) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Resposta resposta) throws Exception {
        return false;
    }

}
