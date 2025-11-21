package br.com.fiap.dao;

import br.com.fiap.model.Usuario;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO(Connection connection){
        this.connection = connection;
    }

    public void saveUsuario(Usuario usuario){
        String sql = "INSERT INTO Usuario (nome, endereco, consumo_mensal, producao_mensal, microrede_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEndereco());
            stmt.setDouble(3, usuario.getConsumoMensal());
            stmt.setDouble(4, usuario.getProducaoMensal());

            if (usuario.getMicroredeId() != null) {
                stmt.setInt(5, usuario.getMicroredeId());
            } else {
                stmt.setNull(5, java.sql.Types.INTEGER);
            }
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar o usuário.");
        }
    }

    public void updateUsuario(Usuario usuario){
        String sql = "UPDATE Usuario SET nome = ?, endereco = ?, consumo_mensal = ?, producao_mensal = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEndereco());
            stmt.setDouble(3, usuario.getConsumoMensal());
            stmt.setDouble(4, usuario.getProducaoMensal());
            stmt.setInt(5, usuario.getId()); // Usamos o ID para identificar usuário
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar o usuário.");
        }
    }

    public void deleteUsuario(Usuario usuario){
        String sql = "DELETE FROM Usuario WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getId());  // Usando o ID do Usuario

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Usuário deletado com sucesso!");
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar o usuário.");
        }
    }

    public void associarUsuarioAMicrorede(int usuarioId, int microredeId) {
        String sql = "UPDATE Usuario SET microrede_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, microredeId);
            stmt.setInt(2, usuarioId);
            stmt.executeUpdate();
            System.out.println("Usuário associado à microrede com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao associar o usuário à microrede.");
        }
    }

}

