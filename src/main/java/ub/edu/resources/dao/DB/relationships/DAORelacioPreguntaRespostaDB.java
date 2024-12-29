package ub.edu.resources.dao.DB.relationships;

import ub.edu.model.ED.Parell;
import ub.edu.resources.dao.relationships.DAORelacioPreguntaResposta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAORelacioPreguntaRespostaDB extends DAORelacioDB<Parell<String, List<Parell<String, Boolean>>>> implements DAORelacioPreguntaResposta {

    private final Connection connection;

    public DAORelacioPreguntaRespostaDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Parell<String, List<Parell<String, Boolean>>>> getAll() {
        List<Parell<String, List<Parell<String, Boolean>>>> relacions = new ArrayList<>();
        String sql = """
            SELECT
                Pregunta.pregunta,
                Resposta.resposta,
                Resposta.correcte
            FROM
                Pregunta_Resposta
                    LEFT JOIN Pregunta ON Pregunta_Resposta.pregunta_id = Pregunta.id
                    LEFT JOIN Resposta ON Pregunta_Resposta.resposta_id = Resposta.id
        """;
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                List<Parell<String, Boolean>> respostes = new ArrayList<>();   // List of answers
                respostes.add(new Parell<>(rs.getString("resposta"), rs.getBoolean("correcte")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return relacions;
    }

    @Override
    public boolean add(Parell<String, List<Parell<String, Boolean>>> stringListParell) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Parell<String, List<Parell<String, Boolean>>> stringListParell) throws Exception {
        return false;
    }

}
