package ub.edu.resources.dao.DB.relationships;

import ub.edu.model.ED.Parell;
import ub.edu.model.ED.Quartet;
import ub.edu.model.ED.Trio;
import ub.edu.resources.dao.relationships.DAORelacioGrupInteresCategoriaPregunta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAORelacioGrupInteresCategoriaPreguntaDB extends  DAORelacioDB<Trio<String, String, String>> implements DAORelacioGrupInteresCategoriaPregunta {

    private final Connection connection;

    public DAORelacioGrupInteresCategoriaPreguntaDB(Connection c) {
        this.connection = c;
    }

    @Override
    public List<Trio<String, String, String>> getAll() {
        List<Trio<String, String, String>> relacions = new ArrayList<>();
        String sql = """
            SELECT                
                GrupInteres.nomGrup,
                GrupInteres_Categoria_Pregunta.categoria,
                Pregunta.pregunta
            FROM
                GrupInteres_Categoria_Pregunta
                    LEFT JOIN GrupInteres ON GrupInteres_Categoria_Pregunta.grup_id = GrupInteres.id
                    LEFT JOIN Pregunta ON GrupInteres_Categoria_Pregunta.pregunta_id = Pregunta.id
        """;
        try (
                ResultSet rs = this.connection.createStatement().executeQuery(sql);
        ){
            while (rs.next()) {
                relacions.add(
                        new Trio<>(
                                rs.getString("nomGrup"),
                                rs.getString("categoria"),
                                rs.getString("pregunta")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return relacions;
    }

}
