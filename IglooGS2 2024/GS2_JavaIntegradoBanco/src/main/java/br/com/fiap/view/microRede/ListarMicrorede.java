package br.com.fiap.view.microRede;

import br.com.fiap.dao.MicroredeDAO;
import br.com.fiap.model.MicroRede;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListarMicrorede {
    private MicroredeDAO microredeDAO;

    private Connection connection;
    public ListarMicrorede(Connection connection) {
        this.connection = connection;
    }

    // Método que consulta as microredes e exibe
    public void listar() {
        List<MicroRede> microredes = new ArrayList<>();
        String sql = "SELECT * FROM Microrede";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                MicroRede microrede = new MicroRede();
                microrede.setId(rs.getInt("id"));
                microrede.setNome(rs.getString("nome"));
                microrede.setTotalProduzido(rs.getDouble("total_produzido"));
                microrede.setTotalConsumido(rs.getDouble("total_consumido"));
                microrede.setEnergiaArmazenada(rs.getDouble("energia_armazenada"));
                microredes.add(microrede);
            }
            // Exibe as microredes
            if (microredes.isEmpty()) {
                System.out.println("Nenhuma microrede cadastrada.");
            } else {
                for (MicroRede microrede : microredes) {
                    System.out.println(microrede);  // Exibe cada microrede (usando o método toString())
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar microredes: " + e.getMessage());
        }
    }
}
