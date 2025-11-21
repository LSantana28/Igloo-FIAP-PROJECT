package br.com.fiap.dao;

import br.com.fiap.model.MicroRede;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MicroredeDAO {

    private Connection connection;

    public MicroredeDAO(Connection connection){
        this.connection = connection;
    }

    // Método para criar uma nova microrede
    public void saveMicrorede(MicroRede microrede) {
        String sql = "INSERT INTO Microrede (nome, total_produzido, total_consumido, energia_armazenada) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, microrede.getNome());
            stmt.setDouble(2, microrede.getTotalProduzido());
            stmt.setDouble(3, microrede.getTotalConsumido());
            stmt.setDouble(4, microrede.getEnergiaArmazenada());
            stmt.executeUpdate();

            System.out.println("Microrede cadastrada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar a microrede.");
        }
    }

    // Método para visualizar todas as microredes
    public List<MicroRede> listAll() {
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
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar microredes.");
        }

        if (microredes.isEmpty()) {
            System.out.println("Nenhuma microrede encontrada.");
        }

        return microredes;
    }

    private MicroredeDAO microredeDAO;

    public void exibirMicroredes() {
        List<MicroRede> microredes = microredeDAO.listAll();
        if (microredes.isEmpty()) {
            System.out.println("Nenhuma microrede encontrada.");
        } else {

            for (MicroRede microrede : microredes) {
                System.out.println(microrede);
            }
        }
    }



    // Método para deletar uma microrede
    public void deleteMicrorede(int id) {
        String sql = "DELETE FROM Microrede WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Microrede deletada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar a microrede.");
        }
    }
}
