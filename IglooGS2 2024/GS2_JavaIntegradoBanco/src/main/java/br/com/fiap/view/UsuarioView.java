package br.com.fiap.view;

import br.com.fiap.dao.MicroredeDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.view.microRede.CadastrarMicrorede;
import br.com.fiap.view.microRede.DeletarMicrorede;
import br.com.fiap.view.microRede.ListarMicrorede;
import br.com.fiap.view.usuario.AtualizarUsuario;
import br.com.fiap.view.usuario.CadastroUsuario;
import br.com.fiap.view.usuario.DeletarUsuario;
import br.com.fiap.view.usuario.VisualizarUsuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class UsuarioView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 9) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Visualizar Usuários");
            System.out.println("3. Atualizar Usuário");
            System.out.println("4. Deletar Usuário");
            System.out.println("5. Associar Usuário a uma microrede");

            System.out.println("6. Cadastrar Microrede");
            System.out.println("7. Listar Microrede");
            System.out.println("8. Deletar Microrede");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            try (Connection connection = ConnectionFactory.getConnection()) {
                switch (opcao) {
                    case 1:
                        CadastroUsuario cadastroUsuario = new CadastroUsuario(connection);
                        cadastroUsuario.cadastrar();
                        break;
                    case 2:
                        VisualizarUsuario visualizarUsuario = new VisualizarUsuario(connection);
                        System.out.println("Escolha uma opção:");
                        System.out.println("1. Visualizar por ID");
                        System.out.println("2. Listar todos os usuários");
                        int escolha = scanner.nextInt();

                        if (escolha == 1) {
                            visualizarUsuario.visualizarPorID();
                        } else if (escolha == 2) {
                            visualizarUsuario.listarTodos();
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 3:
                        AtualizarUsuario atualizarUsuario = new AtualizarUsuario(connection);
                        atualizarUsuario.atualizar();
                        break;

                    case 4:
                        DeletarUsuario deletarUsuario = new DeletarUsuario(connection);
                        deletarUsuario.deletar();
                        break;

                    case 5:
                        System.out.println("Digite o ID do usuário:");
                        int usuarioId = scanner.nextInt();
                        System.out.println("Digite o ID da microrede:");
                        int microredeId = scanner.nextInt();
                        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
                        usuarioDAO.associarUsuarioAMicrorede(usuarioId, microredeId);
                        break;

                    case 6:
                        CadastrarMicrorede cadastrarMicrorede = new CadastrarMicrorede(connection);
                        cadastrarMicrorede.cadastrar();
                        break;

                    case 7:
                        ListarMicrorede listarMicrorede = new ListarMicrorede(connection);
                        listarMicrorede.listar();
                        break;

                    case 8:
                        DeletarMicrorede deletarMicrorede = new DeletarMicrorede(connection);
                        deletarMicrorede.deletar();
                        break;

                    case 9:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } catch (SQLException e) {
                System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            }

        }scanner.close();
    }
}

