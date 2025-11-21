package br.com.fiap.view.usuario;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastroUsuario {
    private UsuarioDAO usuarioDAO;
    private Connection connection;

    public CadastroUsuario(Connection connection) {
        this.connection = connection;
    }
    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- Cadastro de Usuário ----");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Consumo Mensal (em kWh): ");
        int consumoMensal = scanner.nextInt();

        System.out.print("Produção Mensal (em kWh): ");
        int producaoMensal = scanner.nextInt();

        try (Connection connection = ConnectionFactory.getConnection()) {
            Usuario usuario = new Usuario(nome, endereco, consumoMensal, producaoMensal);
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            usuarioDAO.saveUsuario(usuario);
            System.out.println("Usuário cadastrado com sucesso!");
        }catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

    }
}
