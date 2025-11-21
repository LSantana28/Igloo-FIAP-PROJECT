package br.com.fiap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Configurações do banco de dados
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        String user = "RM551430";
        String password = "301104";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão com o banco de dados estabelecida!");

            boolean continuar = true;
            while (continuar) {
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("1. Gerenciar Usuários");
                System.out.println("2. Gerenciar Contas");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer


            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }


}
