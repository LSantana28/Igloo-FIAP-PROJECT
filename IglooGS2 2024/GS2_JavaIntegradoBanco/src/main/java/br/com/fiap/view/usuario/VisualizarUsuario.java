package br.com.fiap.view.usuario;

import br.com.fiap.dao.UsuarioDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class VisualizarUsuario {

    private UsuarioDAO usuarioDAO;
    private Connection connection;

    public VisualizarUsuario(Connection connection) {
        this.connection = connection;
    }

    public void visualizarPorID() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do usuário que deseja visualizar: ");
        int id = scanner.nextInt();

        String sql = "SELECT * FROM Usuario WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Endereço: " + rs.getString("endereco"));
                System.out.println("Consumo Mensal: " + rs.getDouble("consumo_mensal"));
                System.out.println("Produção Mensal: " + rs.getDouble("producao_mensal"));
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário: " + e.getMessage());
        }
    }

    public void listarTodos(){
        String sql = "SELECT * FROM Usuario";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("\nID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Endereço: " + rs.getString("endereco"));
                System.out.println("Consumo Mensal: " + rs.getDouble("consumo_mensal"));
                System.out.println("Produção Mensal: " + rs.getDouble("producao_mensal"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
    }
}
